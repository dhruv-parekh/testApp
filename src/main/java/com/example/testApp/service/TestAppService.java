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

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteuserById(String id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    public User findUserById(String id) {
         return userRepository.findById(id).get();
    }


//    public User getUserById(String id) {
//        return userRepository.findById(id);
//    }
//
//    public User getUser(){
//
//        return userRepository.getUser();
//    }
//
//
//
//    public List<User> getAllUsers() {
//        return userRepository.getAllUsers();
//    }
//
//    public User getUserById(int userId) {
//        return userRepository.getUserByUserId(userId);
//    }
//
//
//
//    public void deleteuserById(int userId) {
//        userRepository.deleteUserById(userId);
//    }
}
