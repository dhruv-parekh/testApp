package com.example.testApp.Repository;

import com.example.testApp.models.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album,String> {
}
