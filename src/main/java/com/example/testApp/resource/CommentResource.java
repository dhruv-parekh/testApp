package com.example.testApp.resource;

import com.example.testApp.model.FirebaseUser;
import com.example.testApp.models.Comment;
import com.example.testApp.models.Photo;
import com.example.testApp.service.CommentService;
import com.example.testApp.service.FirebaseService;
import com.example.testApp.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/commentApi/comments")
public class CommentResource {
    @Autowired
    private CommentService commentService;

    @Autowired
    FirebaseService firebaseService;

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/findId")
    public Comment getCommentById(@RequestParam String id){
        return commentService.findCommentById(id);
    }

    @GetMapping("/findCommentsByPhotoId/{photoId}")
    public List<Comment>  getCommentsByPhotoId(@PathVariable String photoId, @RequestHeader String idToken) throws IOException, FirebaseAuthException {

        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if(firebaseUser!=null) return commentService.getCommentsByPhotoId(photoId);
        return null;

    }

    @GetMapping("/findCreator")
    public List<Comment> getPhotoByCreatedBy(@RequestParam String createdBy){
        return commentService.findCommentByCreatedBy(createdBy);
    }


    @PostMapping
    public String saveComment(@RequestBody @Valid Comment comment){
        return commentService.saveComment(comment);
    }

    @PutMapping
    public String updateComment(@RequestBody @Valid Comment Comment){
        return commentService.updateComment(Comment);
    }

    @DeleteMapping
    public String deleteCommentById(@RequestParam String id){
        return commentService.deleteComment(id);
    }

}
