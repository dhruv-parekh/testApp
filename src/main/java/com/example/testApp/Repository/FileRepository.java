package com.example.testApp.Repository;

import com.example.testApp.models.File;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<File, String> {
    File findByFileName(String fileName);
}
