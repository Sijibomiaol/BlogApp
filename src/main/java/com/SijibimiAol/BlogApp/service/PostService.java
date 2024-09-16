package com.SijibimiAol.BlogApp.service;

import com.SijibimiAol.BlogApp.entity.Post;
import com.SijibimiAol.BlogApp.entity.User;
import com.SijibimiAol.BlogApp.model.UserPrincipal;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

public interface PostService {


    //    @Autowired
    //    private BlikeRepository likeRepository;
    Post createPost(Post post, int userId);

    List<Post> getAllPosts();

    Optional<Post> getPostById(int id);


    Post updatePost(Post post, Authentication authentication);

    void  deletePostById(int id, Authentication authentication);
}
