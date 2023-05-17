package com.example.testApp.resource;

import com.example.testApp.models.Photo;
import com.example.testApp.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/photoApi/photos")
public class PhotoResource {
    @Autowired
    private PhotoService photoService;

    @GetMapping
    public List<Photo> getAllPhotos(){
        return photoService.getAllPhotos();
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