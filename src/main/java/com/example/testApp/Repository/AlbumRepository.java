package com.example.testApp.Repository;

import com.example.testApp.models.Album;
import com.example.testApp.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepository {

    private List<Album> albumList = new ArrayList<>();

    public Album getAlbum() {
        return new Album("album1","Dhruv's Album","R/Codes/ProfilePics/");
    }

    public Album saveUser(Album album) {
        album.setAlbumId(albumList.size()+1);
        albumList.add(album);
        return album;
    }


    public List<Album> getAllAlbums() {
        return albumList;
    }

    public String updateAlbumById(int albumId, Album album) {

        for (Album a:albumList) {
            if (albumId == a.getAlbumId()){
                a.setDescription(album.getDescription());
                a.setName(album.getName());
                a.setCoverPicUrl(album.getCoverPicUrl());
                return "update done.";
            }
        }
        return "no such album found";
    }

    public Album getAlbumById(int albumId) {
        for (Album a:albumList) {
            if (albumId == a.getAlbumId()){
                    return a;
            }
        }
        return null;

    }

    public String deleteAlbum(int albumId) {
        for (Album a:albumList) {
            if (albumId == a.getAlbumId()){
                albumList.remove(a);
                return "album deleted";
            }
        }
        return "no such album found";
    }
}
