package com.group12.bookinghomestay.client.controller.ListingHomeController;

import com.group12.bookinghomestay.client.model.ResponseObject;
import com.group12.bookinghomestay.client.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/api/v1/FileUpload")
public class UploadFileController {
    @Autowired
    private IStorageService storageService;

    @PostMapping("")
    public ResponseEntity<ResponseObject> uploadFile(@RequestParam("file")MultipartFile file){
        try {
            //save file to a folder => use service
            String generatedFileName = storageService.storeFile(file);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","upload file successfully",generatedFileName)
            );
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail",exception.getMessage(),"")
            );
        }
    }
    public String UFile(@RequestParam("file") MultipartFile file){
        try{
            String generatedFileName = storageService.storeFile(file);
            return generatedFileName;
        }catch (Exception exception){
            return null;
        }
    }
    @GetMapping("/files/{fileName:.+}")
    public ResponseEntity<byte[]> readDetailsFile(@PathVariable String fileName){
        try{
            byte[] bytes  = storageService.readFileContent(fileName);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
        }catch(Exception exception){
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseObject> getUploadFiles(){
        try{
            List<String> urls = storageService.loadAll()
                    .map(path -> {
                        String urlPath = MvcUriComponentsBuilder.fromMethodName(UploadFileController.class,
                                "readDetailsFile",path.getFileName().toString()).build().toUri().toString();
                        return urlPath;
                    }).collect(Collectors.toList());
            return ResponseEntity.ok(new ResponseObject("ok","list file success",urls));
        }catch (Exception exception){
            return ResponseEntity.ok(new ResponseObject("fail","list file fail",new String[]{}));
        }
    }

}
