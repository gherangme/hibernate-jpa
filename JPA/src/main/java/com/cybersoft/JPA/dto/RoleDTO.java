package com.cybersoft.JPA.dto;

/*
    Mục đích là tránh vòng lặp vô tận và muốn trả thêm gì ra giao
    diện thì trả ở đây
    Muốn trả ra gì cho ng dùng, thêm thao tác set lại toàn bộ
    giá trị vào data object transform
 */

public class RoleDTO {
    private int id;
    private String name;
    private String desc;

    public RoleDTO() {

    }

    public RoleDTO(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
