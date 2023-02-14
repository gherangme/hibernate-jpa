package com.cybersoft.JPA.service.imp;

import com.cybersoft.JPA.dto.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getAllRole();
    List<RoleDTO> getRoleByName(String name);
}
