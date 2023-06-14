package com.example.testApp;

import com.example.testApp.models.Photo;
import com.example.testApp.service.PhotoService;
import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PhotoServiceTest {

    @Autowired
    private PhotoService photoService;

    @BeforeEach
    public void savePhotoTest(){
        photoService.savePhoto(new Photo("5", "2", "url here", "Ramesh", "date here"));
    }

    @Test
    public void updatePhotoTest(){
        Photo photo = photoService.findPhotoById("5");
        photo.setCreatedBy("Dhruv");
        photoService.updatePhoto(photo);
        Assert.assertEquals("Dhruv", photo.getCreatedBy());
    }

    @Test
    public void findPhotoByIdTest(){
        Photo photo = photoService.findPhotoById("5");
        Assert.assertEquals("Ramesh", photo.getCreatedBy());
    }
    @After
    public void deletePhotoTest(){
        photoService.deletePhoto("5");
    }

}
