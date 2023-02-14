package com.cybersoft.JPA.repository;

import com.cybersoft.JPA.dto.RoleDTO;
import com.cybersoft.JPA.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    Muốn query entity thì tạo ra repository
    Để thực hiện đc câu truy vấn thì tạo ra một interface, interface sẽ kế thừa jparepository của mình

    JpaRepository<Tên Entity, Kiểu dữ liệu của khóa chính trong entity đó>

    @Component: định nghĩa những thuộc tính
    @Service: xử lý logic code
    @Repository: class chuyền về tương tác database
    @Bean thường được khai báo ở @Configuration
    (security sẽ demo phần này)
    đều khởi tạo và đưa lên container dùng chung (IOC)
    Khác nhau tên để phân biệt tên và chức năng

    Lỗi: Khi trả ra list role, dùng ResponEntity trả ra thì nó sài jackson
    và biến ds role thành Json. Thì nó bị vấn đề dữ liệu thì có nhưng xuất ra
    bị lỗi.
    Nguyên nhân vì khi role select data thì nó lấy luôn thằng khóa ngoại là user
    Vào user lấy gặp lại thằng role (JPA tự ngưng nhưng Gson khi gặp thì biến tiếp về json)
    Cách tránh dùng @JsonIgnore: nó sẽ bỏ qua key
 */
@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {
    List<Roles> findByName(String name);
}
