package com.cybersoft.JPA.repository;

import com.cybersoft.JPA.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    List<Users> findByEmailAndPassword(String email, String password);

}
