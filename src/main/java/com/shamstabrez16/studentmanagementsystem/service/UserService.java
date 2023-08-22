package com.shamstabrez16.studentmanagementsystem.service;

import com.shamstabrez16.studentmanagementsystem.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();
   User getUserById(Long id);
    User saveUser(User student);
    void deleteUser(Long id);
    boolean findByUsernameOrEmail(User username);
}
