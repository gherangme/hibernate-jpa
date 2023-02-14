package com.cybersoft.JPA.service;

import com.cybersoft.JPA.dto.UserDTO;
import com.cybersoft.JPA.entity.Roles;
import com.cybersoft.JPA.entity.Users;
import com.cybersoft.JPA.payload.LoginRequest;
import com.cybersoft.JPA.repository.UserRepository;
import com.cybersoft.JPA.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public boolean login(LoginRequest loginRequest) {

        return userRepository.findByEmailAndPassword(loginRequest.getEmail(),loginRequest.getPassword()).size() > 0;

    }

    @Override
    public boolean insertUser(UserDTO userDTO) {

        Roles roles = new Roles();
        roles.setId(userDTO.getRoleId());

        Users users = new Users();
        users.setEmail(userDTO.getEmail());
        users.setPassword(userDTO.getPassword());
        users.setFullName(userDTO.getFullname());
        users.setAvatar(userDTO.getAvatar());
        users.setRoles(roles);
        System.out.println("User Id: "+users.getId());

        try {
            userRepository.save(users);
            return true;
        }catch (Exception e) {
            return false;
        }
    }


}
