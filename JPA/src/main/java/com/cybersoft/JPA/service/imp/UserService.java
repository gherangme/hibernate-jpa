package com.cybersoft.JPA.service.imp;

import com.cybersoft.JPA.dto.UserDTO;
import com.cybersoft.JPA.payload.LoginRequest;

public interface UserService {

    boolean login(LoginRequest loginRequest);
    boolean insertUser(UserDTO userDTO);

}
