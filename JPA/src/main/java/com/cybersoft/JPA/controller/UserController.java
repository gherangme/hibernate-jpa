package com.cybersoft.JPA.controller;

import com.cybersoft.JPA.dto.UserDTO;
import com.cybersoft.JPA.payload.LoginRequest;
import com.cybersoft.JPA.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        userService.insertUser(userDTO);

        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        return new ResponseEntity<>(userService.login(loginRequest), HttpStatus.OK);
    }

}
