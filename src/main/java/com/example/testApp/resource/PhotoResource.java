package com.example.testApp.resource;

import com.example.testApp.model.FirebaseUser;
import com.example.testApp.models.Photo;
import com.example.testApp.service.FirebaseService;
import com.example.testApp.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/photoApi/photos")
public class PhotoResource {
    @Autowired
    private PhotoService photoService;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping
    public List<Photo> getAllPhotos(@RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser !=null)  return photoService.getAllPhotos();
        return null;
    }

    @GetMapping("/findId")
    public Photo getPhotoById(@RequestParam String id){
        return photoService.findPhotoById(id);
    }

    @GetMapping("/findCreator")
    public List<Photo> getPhotoByCreatedBy(@RequestParam String createdBy){
        return photoService.findPhotoByCreatedBy(createdBy);
    }


    @PostMapping
    public String savePhoto(@RequestBody @Valid Photo photo){
        return photoService.savePhoto(photo);
    }

    @PutMapping
    public String updatePhoto(@RequestBody @Valid Photo photo){
        return photoService.updatePhoto(photo);
    }

    @DeleteMapping
    public String deletePhotoById(@RequestParam String id){
        return photoService.deletePhoto(id);
    }

}
