package com.example.testApp.service;

import com.example.testApp.Repository.AlbumRepository;
import com.example.testApp.Repository.PhotoRepository;
import com.example.testApp.models.Album;
import com.example.testApp.models.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private PhotoRepository photoRepository;


    public String saveAlbum(Album album) {
        albumRepository.save(album);
        return  album.getName()+"saved";
    }

    public List<Album> getAllAlbums() {
//        List<Album> albumList= new ArrayList<>();
//        albumList=
               return albumRepository.findAll();
//        return albumList;
    }

    public Album getAlbumById(String albumId) {
        if(albumRepository.existsById(albumId)){
        Album album = albumRepository.findById(albumId).get();
        return album;
        }
        return null;
    }

    public String updateAlbumById(String albumId, Album album) {

        if(albumRepository.existsById(albumId)){
            albumRepository.save(album);
            return "album updated";
        }
        return "Album not found. please try another id.";
    }

    public String deleteAlbum(String albumId) {
        if(albumRepository.existsById(albumId)){
            albumRepository.deleteById(albumId);
            return "Album deleted.";
        }
        return "Album not found. please try again with correct id.";
    }

    public List<Photo> getAllPhotosOfAlbum(String albumId) {

        List<Photo> photoList = photoRepository.findAllByAlbumId(albumId);
        return photoList;
    }
//
}
