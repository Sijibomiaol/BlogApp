package com.SijibimiAol.BlogApp.service;

import com.SijibimiAol.BlogApp.entity.Comment;
import com.SijibimiAol.BlogApp.repository.CommentRepository;
import com.SijibimiAol.BlogApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostService postService;

    @Override
    public Comment addComment(Comment comment, int userId, int postId) {

        comment.setUserId(userId);
        comment.setPostId(postId);
        return commentRepository.save(comment);
    }
    @Override
    public List<Comment> getComments(int postId) {
        return commentRepository.findByPostId(postId);
    }
    @Override
    public List<Comment> getCommentsByUser(int userId) {
        return commentRepository.findByUserId(userId);
    }

    @Override
    public void deleteComment(int commentId, int userId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            if (comment.get().getUserId() == userId) {
                commentRepository.delete(comment.get());
            } else {
                throw new IllegalArgumentException("You are not allowed to delete this comment");
            }

        } else {
            throw new IllegalArgumentException("Comment not found");
        }
    }

}
