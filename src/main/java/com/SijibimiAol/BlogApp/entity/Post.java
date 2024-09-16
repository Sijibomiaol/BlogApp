package com.SijibimiAol.BlogApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private int userId;
    private int likeCount;
    private boolean favorite;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdPostDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedPostDate;


    @PrePersist
    protected void onCreate() {
        createdPostDate = new Date();
        updatedPostDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedPostDate = new Date();
    }

}
