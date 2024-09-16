package com.SijibimiAol.BlogApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Blike {
    @Id
    private int id;
    private boolean liked;
    private int commentId;
    private int postId;
    private int userId;

}
