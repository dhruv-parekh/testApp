package com.example.testApp.service;

import com.example.testApp.Repository.PhotoRepository;
import com.example.testApp.models.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public String savePhoto(Photo photo) {
        photoRepository.save(photo);
        return "saved";
    }

    public String updatePhoto(Photo photo) {
        if (photoRepository.existsById(photo.getId())) {
            photoRepository.save(photo);
            return "Updated";
        }
        return "no such record found";

    }

    public String deletePhoto(String id) {
        if (photoRepository.existsById(id)) {
            photoRepository.deleteById(id);
            return "deleted";
        }
        return "no such record found";
    }

    public Photo findPhotoById(String id) {
        if (photoRepository.existsById(id)) {
            Photo photo = photoRepository.findById(id).get();
            return photo;
        }
        return null;
    }

    public List<Photo> findPhotoByCreatedBy(String createdBy) {

        return photoRepository.findAllByCreatedBy(createdBy);

    }
}
