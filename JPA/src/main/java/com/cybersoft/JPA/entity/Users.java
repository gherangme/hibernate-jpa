package com.cybersoft.JPA.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class Users {

    //Vì code first nên nó sẽ chèn dữ liệu theo ý mình
    //còn DB first sẽ chỉ lấy dữ liệu lên vì dữ liệu đã đc tạo ra trước đó
    //-> không cần các annotation như @Nonnull,... trong DB first
    //Thằng nào giữ khóa ngoại thằng đó luôn bị nhiều ManyToOne
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "avatar")
    private String avatar;

    //DB first: nếu có khóa ngoại và có map quan hệ 1-N N-1
    //Thì khi truy vấn trong entity tự động truy vấn luôn các cột khóa ngoại liên quan
    //Nếu không muốn vấn đề tự truy vấn xảy ra có quyền bỏ luôn cột khóa ngoại
    //Nếu muốn lấy số id ra thôi thì để vậy
//    @Column(name = "role_id")
//    private int roleId;

    @OneToMany(mappedBy = "users")
    private Set<Tasks> tasks;

    @ManyToOne() //Nhiều user chỉ có 1 role
    @JoinColumn(name = "role_id")
    private Roles roles;

    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

//    public int getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
//    }
}
