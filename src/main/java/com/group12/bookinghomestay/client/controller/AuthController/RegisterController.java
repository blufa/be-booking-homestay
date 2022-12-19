package com.group12.bookinghomestay.client.controller.AuthController;

import com.group12.bookinghomestay.client.model.ResponseObject;
import com.group12.bookinghomestay.client.model.UserClient;
import com.group12.bookinghomestay.client.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class RegisterController {

    @Autowired
    private UserClientService userService;

    @PostMapping("/add")
    public String add(@RequestBody UserClient user){
        userService.saveUser(user);
        return "new user is added";
    }

    @GetMapping("/getAll")
    public List<UserClient> list(){
        return userService.getAllUsers();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseObject> getUser(@PathVariable int id){
        Optional<UserClient> findUser = userService.getUserById(id);
        if(findUser.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","find user succesfully",findUser)
            );
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false","can't find user have id ="+id,"")
            );
        }
    }
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertUser(@RequestBody UserClient user){
        List<UserClient> foundUserExist = userService.getListUserByEmail(user.getEmail());
        if(foundUserExist.size()>0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail","user email duplicate","")
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","insert user success",userService.saveUser(user))
        );
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<ResponseObject> getUser(@PathVariable String email){
        Optional<UserClient> findUser = Optional.ofNullable(userService.getUserByEmail(email));
        if(findUser.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK","find user succesfully",findUser)
            );
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false","can't find user have email ="+email,"")
            );
        }
    }

    @PutMapping("/updateUser/{id}")
    ResponseEntity<ResponseObject> updateUser(@RequestBody UserClient newUser,@PathVariable int id){
        Optional<Object> updateUser = Optional.ofNullable(userService.getUserById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setEmail(newUser.getEmail());
                    user.setActive(newUser.getActive());
                    return userService.saveUser(user);
                }).orElseGet(() -> {
                    newUser.setId(id);
                    return userService.saveUser(newUser);
                }));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","update account infomation sucess",updateUser)
        );
    }
}
