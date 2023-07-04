package com.example.testApp.service;

import com.example.testApp.Repository.CommentRepository;
import com.example.testApp.Repository.PhotoRepository;
import com.example.testApp.models.Comment;
import com.example.testApp.models.Photo;
import com.example.testApp.resource.CommentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PhotoRepository photoRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment findCommentById(String id) {
        if (commentRepository.existsById(id)) {
            return commentRepository.findById(id).get();
        }
        return null;
    }

    public List<Comment> findCommentByCreatedBy(String createdBy) {
        return commentRepository.findAllByCreatedBy(createdBy);
    }

    public String saveComment(Comment comment) {
        commentRepository.save(comment);
        return "saved";
    }

    public String updateComment(Comment comment) {
        if (commentRepository.existsById(comment.getId())) {
            commentRepository.save(comment);
            return "updated";
        }
        return "no such record exists.";
    }

    public String deleteComment(String id) {
        if (commentRepository.existsById(id)) {
            commentRepository.deleteById(id);
            return "deleted";
        }
        return "no such record exists.";
    }

    public List<Comment> getCommentsByPhotoId(String photoId) {

        List<Comment> commentList = new ArrayList<>();
        commentList = commentRepository.findAllByPhotoId(photoId);
        return commentList;

    }
}
