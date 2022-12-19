package com.group12.bookinghomestay.client.service.impl;

import com.group12.bookinghomestay.client.service.IStorageService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class ImageServiceImpl implements IStorageService {
    private final Path storageFolder = Paths.get("uploads");

    public ImageServiceImpl(){
        try{
            Files.createDirectories(storageFolder);
        }catch (IOException exception){
            throw new RuntimeException("can not initialize storage",exception);
        }
    }
    private boolean isImageFile(MultipartFile file){
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        return Arrays.asList(new String[] {"png","jpg","jpeg","bmp"}).contains(fileExtension.trim().toLowerCase());
    }
    @Override
    public String storeFile(MultipartFile file) {
        try{
            System.out.println("zzzz");
            if(file.isEmpty()){
                throw new RuntimeException("fail to storage empty file");
            }
            //check file image
            if(!isImageFile(file)){
                throw new RuntimeException("you can only upload image file");
            }
            //check file size < 5mb
            float fileSizeInMegabyte = file.getSize() / 1_000_000.0f;
            if(fileSizeInMegabyte>5.0f){
                throw new RuntimeException("you can only upload image file < 5mb");
            }
            //file must be rename
            String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
            String generateFileName = UUID.randomUUID().toString().replace("-","");
            generateFileName = generateFileName + "."+fileExtension;
            Path destinationFilePath = this.storageFolder.resolve(
                    Paths.get(generateFileName)).normalize().toAbsolutePath();
            if(!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath())){
                throw new RuntimeException("you can not storage file outside current directory");
            }
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream,destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            }
            return generateFileName;
        }catch(IOException exception){
            throw new RuntimeException("fail to storage file",exception);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try{
            return Files.walk(this.storageFolder,1)
                    .filter(path -> !path.equals(this.storageFolder) && !path.toString().contains("._"))
                    .map(this.storageFolder::relativize);
        }catch (IOException exception){
            throw new RuntimeException("fail to load storage file",exception);
        }
    }

    @Override
    public byte[] readFileContent(String fileName) {
        try{
            Path file = storageFolder.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists()||resource.isReadable()){
                byte[] bytes = StreamUtils.copyToByteArray(resource.getInputStream());
                return bytes;
            }
            else {
                throw new RuntimeException("could not read file" +fileName);
            }
        }
        catch(IOException exception){
            throw new RuntimeException("could not read file" +fileName, exception);
        }
    }

    @Override
    public void deleteAllFile() {

    }
}
