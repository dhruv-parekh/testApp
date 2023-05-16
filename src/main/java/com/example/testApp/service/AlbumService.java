package com.example.testApp.service;

import com.example.testApp.Repository.AlbumRepository;
import com.example.testApp.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    public Album getAlbum() {
        return albumRepository.getAlbum();
    }

    public Album saveAlbum(Album album) {
        return albumRepository.saveUser(album);
    }

    public List<Album> getAllAlbums() {
        return albumRepository.getAllAlbums();
    }

    public String updateAlbumById(int albumId, Album album) {
        return   albumRepository.updateAlbumById(albumId,album);
    }

    public Album getAlbumById(int albumId) {
        return albumRepository.getAlbumById(albumId);
    }

    public String deleteAlbum(int albumId) {
        return albumRepository.deleteAlbum(albumId);
    }
}
