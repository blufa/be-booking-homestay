package com.group12.bookinghomestay.client.controller.AuthController;


import com.group12.bookinghomestay.admin.model.Customer;
import com.group12.bookinghomestay.admin.model.Owner;
import com.group12.bookinghomestay.client.dto.UserDto;
import com.group12.bookinghomestay.client.model.ResponseObject;
import com.group12.bookinghomestay.client.model.UserClient;
import com.group12.bookinghomestay.client.service.CustomerClientService;
import com.group12.bookinghomestay.client.service.EmaiService.EmailSenderService;
import com.group12.bookinghomestay.client.service.OwnerClientService;
import com.group12.bookinghomestay.client.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class RegisterController {


    @Autowired
    private UserClientService userService;

    @Autowired
    private CustomerClientService customerService;
    @Autowired
    private OwnerClientService ownerService;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    @Autowired
    EmailSenderService emailService;
/*
    @PostMapping("/add")
    public String add(@RequestBody UserClient user){
        userService.saveUser(user);
        return "new user is added";
    }

 */

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
    ResponseEntity<ResponseObject> insertUser(@RequestBody UserDto userDto){
        List<UserClient> foundUserExist = userService.getListUserByEmail(userDto.getEmail());
        List<UserClient> foundUserNameExist = userService.getAllUserByUserName(userDto.getUsername());
        if(foundUserExist.size()>0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("fail","user email duplicate","")
            );
        }
        if(foundUserNameExist.size()>0){
            new ResponseObject("fail","user name is duplicate","");
        }
        int role=0;
        String token = KeyGenerators.string().generateKey();
        String provideKey= KeyGenerators.string().generateKey();
        String provideType= KeyGenerators.string().generateKey();
        long id = 1;
        int active = 0;
        UserClient newUser = new UserClient(
                userDto.getUsername()
                , encoder.encode(userDto.getPassword())
                , userDto.getEmail()
                ,role
                ,token
                ,provideKey
                ,provideType
                ,active);
        Customer newCustomer = new Customer(
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getName(),
                userDto.getCountry(),
                userDto.getPhone()
        );
        Owner newOwner = new Owner(
                userDto.getUsername(),
                userDto.getName(),
                userDto.getPhone());
        String Subject ="hi this is active account email";
        String body = "hi you must active account to register here is link: http://localhost:3000/Active/"+token;
        emailService.sendSimpleEmail(userDto.getEmail(),body,Subject);
        customerService.saveCustomer(newCustomer);
        ownerService.saveOwner(newOwner);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","insert user success",userService.saveUser(newUser))
        );
    }
/*
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

 */

    @PutMapping("/active/{token}")
    ResponseEntity<ResponseObject> activeAccount(@PathVariable String token){
        UserClient currentUser = userService.getUserByToken(token);
        currentUser.setActive(1);
        userService.saveUser(currentUser);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","update account infomation sucess",currentUser)
        );
    }
    /*
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
    */
    //check login function
    @GetMapping("/login/{username}&{password}")
     public UserClient checkLogin(@PathVariable String username,@PathVariable String password){
        UserClient user = userService.getUserByUserName(username);
        if (user == null){
            return null;
        }
        else{
            if(user.getActive()!=1){
                return null;
            }
            else{
                if(encoder.matches(password,user.getPassword())){
                    return user;
                }
                return null;
            }

        }
    }
    //send link to reset account
    @PostMapping("/updateAccount/")
    ResponseEntity<ResponseObject> forgetAccount(@PathVariable String email){
        UserClient user = userService.getUserByEmail(email);
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("fail","user not found","")
            );
        }
        else{
            //send email
            String Subject ="this is active account email";
            String body = "please confirm to complete change password : localhost:8080/user/setAccount/"+user.getToken();
            emailService.sendSimpleEmail(user.getEmail(),body,Subject);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","send email success",user)
            );
        }
    }
    //forget password after link
    @PutMapping("/setAccount/{token}&{password}&{confirmPassword}")
    public UserClient setAccount(@PathVariable String token, @PathVariable String password,@PathVariable String confirmPassword){
        UserClient user = userService.getUserByToken(token);
        if(password==confirmPassword){
            user.setPassword(encoder.encode(password));
            return userService.saveUser(user);
        }
        return null;
    }

}
