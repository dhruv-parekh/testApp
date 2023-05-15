package com.example.testApp.resource;

import com.example.testApp.models.User;
import com.example.testApp.service.TestAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private TestAppService testAppService;
    @GetMapping("/user")
    public User getUser(){

        return testAppService.getUser();
    }

}
