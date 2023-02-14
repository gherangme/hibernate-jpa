package com.cybersoft.JPA.service;

import com.cybersoft.JPA.dto.RoleDTO;
import com.cybersoft.JPA.entity.Roles;
import com.cybersoft.JPA.repository.RoleRepository;
import com.cybersoft.JPA.service.imp.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
    Class đưa lên bean từ 1 controller thay đổi giá trị các thuộc tính
    của class đó thì class thứ 2 gọi thằng đó thì nó cũng bị thay đổi
 */
@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAllRole() {
        /*
            khi trả ra cho người dùng thì trả thông qua dto
            để giấu tên cột tránh bị rò rỉ database
         */
        List<Roles> list = roleRepository.findAll();
        List<RoleDTO> dtoList = new ArrayList<>();

        for (Roles data: list) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setDesc(data.getDesc());

            dtoList.add(roleDTO);
        }

        return dtoList;
    }

    @Override
    public List<RoleDTO> getRoleByName(String name) {
        /*
            khi trả ra cho người dùng thì trả thông qua dto
            để giấu tên cột tránh bị rò rỉ database
         */
        List<Roles> list = roleRepository.findByName(name);
        List<RoleDTO> dtoList = new ArrayList<>();

        for (Roles data: list) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setId(data.getId());
            roleDTO.setName(data.getName());
            roleDTO.setDesc(data.getDesc());

            dtoList.add(roleDTO);
        }

        return dtoList;
    }
}
