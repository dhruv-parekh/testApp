package com.example.testApp;

import com.example.testApp.models.Album;
import com.example.testApp.service.AlbumService;
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
class AlbumServiceTests {
    @Autowired
    private AlbumService albumService;

    @BeforeEach
    public void saveAlbum() {
        albumService.saveAlbum(new Album("1", "AlbumName", "description of album",
                "c:/sample/sample", "Dhruv", "date here"));
    }

    @Test
    public void getAlbumById() {
        Album album = albumService.getAlbumById("1");
        Assert.assertEquals("Arpit", album.getCreatedBy());
    }

    @Test
    public void editAlbum() {
        Album album = albumService.getAlbumById("1");
        album.setName("jacks album");
        album.setCreatedBy("Arpit");
        albumService.updateAlbumById(album);
        Assert.assertEquals("jacks", album.getName());
    }

    @After
    public void deleteAlbum() {
        System.out.println("in delete album method");
        albumService.deleteAlbum("1");
    }

}
