package com.sudhir.stockbackend.controller;

import com.sudhir.stockbackend.model.LoginRequest;
import com.sudhir.stockbackend.model.UserRequest;
import com.sudhir.stockbackend.model.UserResponse;
import com.sudhir.stockbackend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/hello")
    public String userHello(){
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request) {
        UserResponse response = service.createUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest request){
        return service.loginUser(request);
    }

}
