package com.example.testApp.Repository;

import com.example.testApp.models.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findAllByCreatedBy(String createdBy);

    List<Comment> findAllByPhotoId(String photoId);
}
