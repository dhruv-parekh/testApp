package com.example.testApp.resource;

import com.example.testApp.models.User;
import com.example.testApp.service.TestAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private TestAppService testAppService;
    @GetMapping("/user")
    public User getUser(){
        return testAppService.getUser();
    }

    //@RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping( value = "/user")
    public User saveUser(@RequestBody User user){
       return testAppService.saveUser(user);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return testAppService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable int userId){
        return testAppService.getUserById(userId);
    }

    @PutMapping("/user/{userId}")
    public User updateUserById(@PathVariable int userId, @RequestBody User user){
        return testAppService.updateUserById(userId,user);
    }

    @DeleteMapping("/user")
    public void deleteUserById(@RequestParam int userId){
        testAppService.deleteuserById(userId);
    }
}
