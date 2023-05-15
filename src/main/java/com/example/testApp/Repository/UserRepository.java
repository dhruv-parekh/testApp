package com.example.testApp.Repository;

import com.example.testApp.models.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public User getUser(){
        return new User("Dhruv","Canada",29,"R/Codes/ProfilePics/");
    }
}
