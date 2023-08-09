package com.example.testApp.Repository;

import com.example.testApp.models.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlbumRepository extends MongoRepository<Album,String> {
    List<Album> findAllByCreatedBy(String createdBy);
}
