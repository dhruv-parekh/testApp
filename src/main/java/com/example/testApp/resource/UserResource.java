package com.example.testApp.resource;

import com.example.testApp.exception.RestrictedInfoException;
import com.example.testApp.model.FirebaseUser;
import com.example.testApp.models.User;
import com.example.testApp.service.FirebaseService;
import com.example.testApp.service.TestAppService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.OPTIONS,RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
@RestController
@RequestMapping("/userApi/users")
public class UserResource {

    @Autowired
    private TestAppService testAppService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping
    public User saveUser(@RequestBody @Valid User user) throws IOException, FirebaseAuthException {
//        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
//        if(firebaseUser != null){
            return testAppService.saveUser(user);
//        }
//        return null;

    }

//    @PostMapping
//    public User saveUser(@RequestBody @Valid User user) {
//            return testAppService.saveUser(user);
//    }

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

    @GetMapping("/FindUserByEmail/{email}")
    public User findUserByEmail(@RequestHeader(name = "idToken") String idToken, @PathVariable String email ) throws IOException, FirebaseAuthException {

        FirebaseUser firebaseuser = firebaseService.authenticate(idToken);
        if(firebaseuser!=null){
            return testAppService.findUserByEmail(email);
        }
        return null;
    }

    @PutMapping
    public User updateUserById( @RequestBody @Valid User user){
        return testAppService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUserById(@RequestParam(name = "id") String id){
        testAppService.deleteuserById(id);
    }

//    @CrossOrigin(origins = "http://localhost:4200/")
    @PutMapping("/updateProfilePic")
    public String updateUserProfilePic(@RequestParam(name = "profilePicUrl") String profilePicUrl,@RequestParam(name = "email") String email ) throws IOException, FirebaseAuthException {
        System.out.println("in update profile method:"+email+" profile pic:"+profilePicUrl);
//        FirebaseUser firebaseuser = firebaseService.authenticate(idToken);
//        if(firebaseuser!=null){
            System.out.println("in update profile method******");
            return testAppService.updateUserProfilePic(email,profilePicUrl);
//        }
//        System.out.println("in update profile method user not found");
//        return " user not found";
    }

}
