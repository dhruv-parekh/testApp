package com.example.testApp.service;

import com.example.testApp.Repository.UserRepository;
import com.example.testApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestAppService {

    @Autowired
    private UserRepository userRepository;
    public User getUser(){

        return userRepository.getUser();
    }

}
