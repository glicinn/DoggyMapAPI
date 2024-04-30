package com.example.doggymapapi.repos;

import com.example.doggymapapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
