package com.example.testApp.resource;

import com.example.testApp.models.User;
import com.example.testApp.service.TestAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userApi/users")
public class UserResource {

    @Autowired
    private TestAppService testAppService;


    @PostMapping
    public User saveUser(@RequestBody User user){
        return testAppService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return testAppService.getAllUsers();
    }

    @GetMapping("/find")
    public List<User> findAllByName(@RequestParam String name){
        return testAppService.findAllByName(name);
    }

    @PutMapping
    public User updateUserById( @RequestBody User user){
        return testAppService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUserById(@RequestParam(name = "id") String id){
        testAppService.deleteuserById(id);
    }

}
