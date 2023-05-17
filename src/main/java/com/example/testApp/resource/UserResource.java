package com.example.testApp.resource;

import com.example.testApp.exception.RestrictedInfoException;
import com.example.testApp.models.User;
import com.example.testApp.service.TestAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/userApi/users")
public class UserResource {

    @Autowired
    private TestAppService testAppService;


    @PostMapping
    public User saveUser(@RequestBody @Valid User user){
        return testAppService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return testAppService.getAllUsers();
    }

    @GetMapping("/find")
    public List<User> findAllByName(@RequestParam String name) throws RestrictedInfoException {
        if(name.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return testAppService.findAllByName(name);
    }

    @GetMapping("/find-by-id")
    public User findUserById(@RequestParam String id){
        return testAppService.findUserById(id);
    }


    @PutMapping
    public User updateUserById( @RequestBody @Valid User user){
        return testAppService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUserById(@RequestParam(name = "id") String id){
        testAppService.deleteuserById(id);
    }

}
