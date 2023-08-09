package com.example.testApp.resource;

import com.example.testApp.model.FirebaseUser;
import com.example.testApp.models.Album;
import com.example.testApp.models.Photo;
import com.example.testApp.service.AlbumService;
import com.example.testApp.service.FirebaseService;
import com.example.testApp.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class AlbumResources {

    @Autowired
    private AlbumService albumService;


    @Autowired
    private FirebaseService firebaseService;


//    @GetMapping("/album")
//    public Album getAlbum(){
//        return albumService.getAlbum();
//    }

    @PostMapping("/album")
    public String saveAlbum(@RequestHeader(name = "idToken") String idToken ,@RequestBody @Valid Album album) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null){
            album.setAlbumId(null);
            return  albumService.saveAlbum(album);
        }
        return "Error occured";

    }

    @GetMapping("/album/{albumId}")
    public Album getAlbumById(@PathVariable String albumId){

        System.out.println("**************here in the get album by id method*********"+albumId);
        Album album = albumService.getAlbumById(albumId);
        System.out.println("album:***** "+album.getName());
        return album;
    }

    @GetMapping("/album/{albumId}/photos")
    public List<Photo> getAllPhotosOfAlbum(@PathVariable String albumId, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null) return albumService.getAllPhotosOfAlbum(albumId);
        return null;
    }


    @GetMapping("/allAlbums")
    public List<Album> getALlAlbums(@RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null)   return albumService.getAllAlbums();
        return null;
    }

    @GetMapping("/AllAlbumsByUserEmail/{userEmail}")
   public List<Album> getAllAlbumsByUserEmail(@PathVariable String userEmail){

        return albumService.getAllAlbumsByUserEmail(userEmail);

    }

    @PutMapping("/album")
    public String updateAlbum(@RequestBody @Valid Album album){
        System.out.println("********** here"+album.getAlbumId());
        return albumService.updateAlbumById(album);
    }

    @DeleteMapping("/album")
    public String deleteAlbum(@RequestParam String albumId){
        System.out.println("in album resource: "+albumId);
        return albumService.deleteAlbum(albumId);
    }

}
