package com.SijibimiAol.BlogApp.repository;

import com.SijibimiAol.BlogApp.entity.Blike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlikeRepository extends JpaRepository<Blike, Integer> {

    List<Blike> findBlikeByPostId(int postId);
    List<Blike>  findBlikeByCommentId(int commentId);


}
