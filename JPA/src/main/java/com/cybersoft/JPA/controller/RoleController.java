package com.cybersoft.JPA.controller;

import com.cybersoft.JPA.dto.RoleDTO;
import com.cybersoft.JPA.entity.Roles;
import com.cybersoft.JPA.repository.RoleRepository;
import com.cybersoft.JPA.service.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//obfucate: làm mờ code
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;
    //Autowire RoleService để khử dependency

    @GetMapping("")
    public ResponseEntity<?> getAllRole() {



        return new ResponseEntity<>(roleService.getAllRole(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getRoleByName(@PathVariable String name) {



        return new ResponseEntity<>(roleService.getRoleByName(name), HttpStatus.OK);
    }
}
