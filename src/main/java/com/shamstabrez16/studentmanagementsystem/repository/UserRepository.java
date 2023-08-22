package com.shamstabrez16.studentmanagementsystem.repository;

import com.shamstabrez16.studentmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
