package com.example.testApp.Repository;

import com.example.testApp.models.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhotoRepository extends MongoRepository<Photo,String> {

    List<Photo> findAllByCreatedBy(String createdBy);
}
