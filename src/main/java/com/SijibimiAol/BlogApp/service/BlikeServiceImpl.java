package com.SijibimiAol.BlogApp.service;


import com.SijibimiAol.BlogApp.entity.Blike;
import com.SijibimiAol.BlogApp.repository.BlikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlikeServiceImpl implements BlikeService{

    @Autowired
    private BlikeRepository blikeRepository;


    @Override
    public Blike addBlike(Blike blike){
        return blikeRepository.save(blike);
    }

    @Override
    public List<Blike> findAllBlikePostId(int postId){
        return blikeRepository.findBlikeByPostId(postId);
    }

    @Override
    public List<Blike> findBlikeByCommentId(int commentId){
        return blikeRepository.findBlikeByCommentId(commentId);
    }
    @Override
    public void deleteBlike(int id){
         blikeRepository.deleteById(id);
    }

}
