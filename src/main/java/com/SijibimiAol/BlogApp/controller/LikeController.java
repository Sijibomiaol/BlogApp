package com.SijibimiAol.BlogApp.controller;

import com.SijibimiAol.BlogApp.entity.Blike;
import com.SijibimiAol.BlogApp.service.BlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private BlikeService likeService;

    @PostMapping("/liked")
    public ResponseEntity<Blike> like(@RequestBody Blike blike){
        Blike savedlike = likeService.addBlike(blike);
        return ResponseEntity.ok(savedlike);
    }
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Blike>>  getLikebyPostId (@PathVariable("postId") int postId){
        List<Blike> likedpost = likeService.findAllBlikePostId(postId);
        return ResponseEntity.ok(likedpost);
    }

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<List<Blike>>  getLikebyCommentId (@PathVariable("commentId") int commentId){
        List<Blike> likes = likeService.findBlikeByCommentId(commentId);
        return ResponseEntity.ok(likes);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        likeService.deleteBlike(id);
        return ResponseEntity.ok().build();
    }
}
