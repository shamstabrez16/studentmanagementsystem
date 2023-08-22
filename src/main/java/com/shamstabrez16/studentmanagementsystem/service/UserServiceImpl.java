package com.shamstabrez16.studentmanagementsystem.service;

import com.shamstabrez16.studentmanagementsystem.model.User;
import com.shamstabrez16.studentmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    public final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public User saveUser(User user) { return userRepository.save(user);
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public boolean findByUsernameOrEmail(User username) {
        User user = userRepository.findByEmail(username.getEmail());
        if(user!=null){
            return user.getEmail().equals(username.getEmail()) && user.getSecretkey().equals(username.getSecretkey());
        }
        return false;

    }
}
