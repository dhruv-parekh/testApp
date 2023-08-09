package com.example.testApp.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.testApp.Repository.AlbumRepository;
import com.example.testApp.Repository.FileRepository;
import com.example.testApp.Repository.PhotoRepository;
import com.example.testApp.models.Album;
import com.example.testApp.models.File;
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

    @Autowired
    private PhotoService photoService;
    @Autowired
    private FileService fileService;

    @Autowired
    private FileRepository fileRepository;

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

    public String updateAlbumById(Album album) {

        if(albumRepository.existsById(album.getAlbumId())){
            System.out.println("in service****** "+album.getCoverPicUrl());
            albumRepository.save(album);
            return "album updated";
        }
        return "Album not found. please try another id.";
    }

    public String deleteAlbum(String albumId) {
        System.out.println("*****album id:"+albumId);
        if(albumRepository.existsById(albumId)){

            //get list of photos from album to delete them one by one
            ArrayList<Photo> photoList = (ArrayList<Photo>) photoRepository.findAllByAlbumId(albumId);

            //delete photos one by one
            for(Photo photo:photoList){
                System.out.println("******in delete album method photoID: "+photo.getId());
                photoService.deletePhoto(photo.getId());

            }

            String coverPicUrl = albumRepository.findById(albumId).get().getCoverPicUrl();
            String fileId = coverPicUrl.replaceAll("https://localhost:8080/fileApi/file/view/","");
            File photoFile = fileRepository.findById(fileId).get();
            String fileNameOnS3 = photoFile.getFileName();
            System.out.println("***** here is file name from file db****: "+fileNameOnS3);

            // delete file from aws;
            fileService.deleteFile(fileNameOnS3);
            //delete cover picture for album form file table
            fileRepository.deleteById(fileId);
            //delete album now
            albumRepository.deleteById(albumId);
            return "Album deleted.";
        }
        return "Album not found. please try again with correct id.";
    }

    public List<Photo> getAllPhotosOfAlbum(String albumId) {

        List<Photo> photoList = photoRepository.findAllByAlbumId(albumId);
        return photoList;
    }

    //here created by  = user email
    public List<Album> getAllAlbumsByUserEmail(String createdBy) {
        return albumRepository.findAllByCreatedBy(createdBy);

    }
//
}
