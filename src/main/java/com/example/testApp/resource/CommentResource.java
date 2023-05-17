package com.example.testApp.resource;

import com.example.testApp.models.Comment;
import com.example.testApp.models.Photo;
import com.example.testApp.service.CommentService;
import com.example.testApp.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commentApi/comments")
public class CommentResource {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/findId")
    public Comment getCommentById(@RequestParam String id){
        return commentService.findCommentById(id);
    }

    @GetMapping("/findCreator")
    public List<Comment> getPhotoByCreatedBy(@RequestParam String createdBy){
        return commentService.findCommentByCreatedBy(createdBy);
    }


    @PostMapping
    public String saveComment(@RequestBody Comment comment){
        return commentService.saveComment(comment);
    }

    @PutMapping
    public String updateComment(@RequestBody Comment Comment){
        return commentService.updateComment(Comment);
    }

    @DeleteMapping
    public String deleteCommentById(@RequestParam String id){
        return commentService.deleteComment(id);
    }

}
