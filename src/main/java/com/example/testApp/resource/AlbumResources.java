package com.example.testApp.resource;

import com.example.testApp.model.FirebaseUser;
import com.example.testApp.models.Album;
import com.example.testApp.service.AlbumService;
import com.example.testApp.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumResources {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private FirebaseService firebaseService;


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
    public List<Album> getALlAlbums(@RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null)   return albumService.getAllAlbums();
        return null;
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
