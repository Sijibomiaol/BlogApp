package com.SijibimiAol.BlogApp.controller;

import com.SijibimiAol.BlogApp.entity.Comment;
import com.SijibimiAol.BlogApp.entity.User;
import com.SijibimiAol.BlogApp.model.UserPrincipal;
import com.SijibimiAol.BlogApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/comment/{post_id}")
    public ResponseEntity<Comment> createComment(@PathVariable("post_id") int postId,
                                                 @RequestBody Comment comment,
                                                 Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        int userId = userPrincipal.getUser().getId();
        Comment createdComment = commentService.addComment(comment, userId, postId);
        return ResponseEntity.ok(createdComment);
    }

    @GetMapping("/comment/post/{postId}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable("postId") int postId) {
        List<Comment> comments = commentService.getComments(postId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/comment/{userId}")
    public ResponseEntity<List<Comment>> getComment(@PathVariable("userId") int userId) {
        List<Comment> commentsByUser = commentService.getCommentsByUser(userId);
        return ResponseEntity.ok(commentsByUser);
    }

    @DeleteMapping("/commentId")
    public ResponseEntity<Comment> deleteComment(@PathVariable("commentId") int commentId,
                                                 Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        int userId = userPrincipal.getUser().getId();
        commentService.deleteComment(commentId, userId);
        return ResponseEntity.ok(null);
    }


}
