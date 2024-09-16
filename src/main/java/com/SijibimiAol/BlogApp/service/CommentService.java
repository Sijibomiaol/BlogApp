package com.SijibimiAol.BlogApp.service;

import com.SijibimiAol.BlogApp.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment, int userId, int postId);

    List<Comment> getComments(int postId);

    List<Comment> getCommentsByUser(int userId);

    void deleteComment(int commentId, int userId);
//    Comment createComment(Comment comment, int post_id, int user_id);
//
//
//    List<Comment> getCommentByPost(int post_id);
//
//    List<Comment> getCommentsByUser(int author_id);
//
//    void deleteComment(int post_id, int comment_id, int author_id);
}
