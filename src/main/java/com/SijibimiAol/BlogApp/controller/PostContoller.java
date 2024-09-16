package com.SijibimiAol.BlogApp.controller;

import com.SijibimiAol.BlogApp.entity.Post;
import com.SijibimiAol.BlogApp.entity.User;
import com.SijibimiAol.BlogApp.model.UserPrincipal;
import com.SijibimiAol.BlogApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class PostContoller {

    @Autowired
    private PostService postService;



    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        User user =  userPrincipal.getUser();

        return postService.createPost(post, user.getId());
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("post/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        Optional<Post> post = postService.getPostById(id);
        return post.map(ResponseEntity::ok).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PutMapping("update/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable("postId") int id,
                                           @RequestBody Post post, Authentication authentication) {
            post.setId(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
        User user =  userPrincipal.getUser();
        user.getId();
        try {
          Post updatedPost = postService.updatePost(post, authentication);
          return ResponseEntity.ok(updatedPost);
      }catch (IllegalStateException e) {
            return ResponseEntity.status(403).body(null);

        }


    }

    @DeleteMapping("delete/comment/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") int postId, Authentication authentication) {

        try {
            postService.deletePostById(postId, authentication);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(403).build();
        }
    }

//    public  ResponseEntity<Void> likePost(@PathVariable int postId, @RequestParam boolean like) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//        User user = userPrincipal.getUser();
//
//        postService.likePost(user.getId(), postId, like);
//        return ResponseEntity.ok().build();
//    }


    }



