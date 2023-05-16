package com.example.testApp.service;

import com.example.testApp.Repository.UserRepository;
import com.example.testApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestAppService {

    @Autowired
    private UserRepository userRepository;
    public User getUser(){

        return userRepository.getUser();
    }

    public User saveUser(User user) {
        return userRepository.saverUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(int userId) {
        return userRepository.getUserByUserId(userId);
    }

    public User updateUserById(int userId, User user) {
        return userRepository.updateUserById(userId,user);
    }

    public void deleteuserById(int userId) {
        userRepository.deleteUserById(userId);
    }
}
