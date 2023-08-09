package com.example.testApp.service;

import com.example.testApp.Repository.FileRepository;
import com.example.testApp.Repository.PhotoRepository;
import com.example.testApp.models.File;
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

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileService fileService;

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
            //get photo to extract picture url from it so we can get fileId out from file table.
            Photo photo = photoRepository.findById(id).get();
            String photoUrl = photo.getPhotoUrl();
            String fileId = photoUrl.replaceAll("https://localhost:8080/fileApi/file/view/","");
            System.out.println("***** here is file id****: "+fileId);

            //get file to extract filename from it so we can delete file from aws.
            File photoFile = fileRepository.findById(fileId).get();
            String fileNameOnS3 = photoFile.getFileName();
            System.out.println("***** here is file name from file db****: "+fileNameOnS3);

            // delete file from aws;
            fileService.deleteFile(fileNameOnS3);

            //delete file from filedb
            fileRepository.deleteById(fileId);
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
