package com.SijibimiAol.BlogApp.service;

import com.SijibimiAol.BlogApp.entity.Post;
import com.SijibimiAol.BlogApp.entity.User;
import com.SijibimiAol.BlogApp.model.UserPrincipal;
import com.SijibimiAol.BlogApp.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpli implements PostService {

//    private UserPrincipal principal;

    @Autowired
    private PostRepository postRepository;

//    @Autowired
//    private BlikeRepository likeRepository;
    @Override
    public Post createPost(Post post, int userId) {
        post.setUserId(userId);
            return postRepository.save(post);
        }
    @Override
    public List<Post> getAllPosts(){
            return postRepository.findAll();
        }
    @Override
    public Optional<Post> getPostById(int id){
            return postRepository.findById(id);
        }
    @Override
    public Post updatePost(Post post, Authentication authentication){
            Optional<Post> existingPost = postRepository.findById(post.getId());

            if(existingPost.isPresent()){
                Post updatedPost = existingPost.get();
                int currentUserId = getCurrentUserId(authentication);
                if(updatedPost.getUserId()==currentUserId){
                    updatedPost.setTitle(post.getTitle());
                    updatedPost.setContent(post.getContent());
                    return postRepository.save(updatedPost);
                }
                else {
                    throw new IllegalArgumentException("You can't update this post you are not the author");
                }
            }
            else {
                throw  new IllegalArgumentException("Post not found");
            }

    }
    @Override
    public void  deletePostById(int id, Authentication authentication){
        Optional<Post> existingPost = postRepository.findById(id);
        if(existingPost.isPresent()){
            Post post = existingPost.get();
            int currentUserId = getCurrentUserId(authentication);
            if(post.getUserId() == currentUserId){
                postRepository.delete(post);
            }
            else {
                throw  new IllegalArgumentException("You are not authorized to delete this post");
            }

        }
        else {
            throw  new IllegalArgumentException("Post not found");
        }

    }

    private  int getCurrentUserId(Authentication authentication){
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        return userDetails.getUser().getId();
    }







//    @Override
//    public void  likePost(int userId, int postId, boolean like){
//        Optional<Blike> likeOptional = likeRepository.findBlikeByUserIdAndPostId(userId, postId);
//        if(likeOptional.isPresent()){
//            Blike like1 = likeOptional.get();
//            like1.setLiked(like);
//            likeRepository.save(like1);
//        }
//        else {
//            Blike newlike = new Blike();
//            newlike.setUserId(userId);
//            newlike.setPostId(postId);
//            newlike.setLiked(like);
//            likeRepository.save(newlike);
//        }
//    }
//
//
//
//


}
