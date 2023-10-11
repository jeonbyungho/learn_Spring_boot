package com.training.jpa.board.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class Post {
   private String author;
   private String content;
   private Integer likeCount;
   private LocalDateTime dateCreated;
   private LocalDateTime dateModified;
   
}
