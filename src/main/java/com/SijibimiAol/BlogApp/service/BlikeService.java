package com.SijibimiAol.BlogApp.service;

import com.SijibimiAol.BlogApp.entity.Blike;

import java.util.List;

public interface BlikeService {
    Blike addBlike(Blike blike);

    List<Blike> findAllBlikePostId(int postId);

    List<Blike> findBlikeByCommentId(int commentId);

    void deleteBlike(int id);
}
