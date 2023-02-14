package com.cybersoft.JPA.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "roles")
public class Roles {

    /*
        Muốn query role lấy danh sách user thì role phải thêm OneToMany
        line 26, 27
     */

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //tự động tăng. identity sequence thường dùng nhất
    private int id;

    @Column(name = "name")
    //Column mapping cột nào trong db thì ghi ra
    //nếu trùng tên có thể ko ghi (như id ở trên) cũng đc
    private String name;

    @Column(name = "description")
    private String desc;

    @OneToMany(mappedBy = "roles")
    private Set<Users> users;

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
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
