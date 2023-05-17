package com.example.testApp.resource;

import com.example.testApp.models.Album;
import com.example.testApp.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumResources {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/album")
    public Album getAlbum(){
        return albumService.getAlbum();
    }

    @PostMapping("/album")
    public Album saveAlbum(@RequestBody @Valid Album album){
        return albumService.saveAlbum(album);
    }

    @GetMapping("/album/{albumId}")
    public Album getAlbumById(@PathVariable int albumId){
        return albumService.getAlbumById(albumId);
    }

    @GetMapping("/allAlbums")
    public List<Album> getALlAlbums(){
        return albumService.getAllAlbums();
    }



    @PutMapping("/album/{albumId}")
    public String updateAlbum(@PathVariable int albumId, @RequestBody @Valid Album album){
        return albumService.updateAlbumById(albumId, album);
    }

    @DeleteMapping("/album")
    public String deleteAlbum(@RequestParam int albumId){
        return albumService.deleteAlbum(albumId);
    }

}
