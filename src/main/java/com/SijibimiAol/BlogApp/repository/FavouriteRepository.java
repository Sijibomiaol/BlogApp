package com.SijibimiAol.BlogApp.repository;

import com.SijibimiAol.BlogApp.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends JpaRepository<Favorite, Integer> {
}
