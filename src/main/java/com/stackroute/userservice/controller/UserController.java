package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1")
public class UserController {
    UserService userService;
    public  UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("user")
    public ResponseEntity<?> saveuser(@RequestBody User user)
    {
        ResponseEntity<?> responseEntity;
        try{
            userService.saveUser(user);
            responseEntity=new ResponseEntity<>("Successfully created",HttpStatus.CREATED);
        }catch (UserAlreadyExistsException e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            e.printStackTrace();
        }
        return responseEntity;

    }

    @GetMapping("user")
    public  ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
}
