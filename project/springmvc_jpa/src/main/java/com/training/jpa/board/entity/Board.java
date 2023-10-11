package com.training.jpa.board.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@SequenceGenerator(name = "board_seq_generator", sequenceName = "board_seq"
                  ,initialValue = 1, allocationSize = 1)
@Getter @ToString(exclude = "replyList")
@NoArgsConstructor @AllArgsConstructor @Builder
public class Board {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE
                  , generator = "board_seq_generator")
   @Column(name = "board_id")
   private Long id;
   private String title;
   private Integer viewCount;

   @Embedded
   private Post post;
   
   @Builder.Default
   @OneToMany(mappedBy = "board")
   List<Reply> replyList = new ArrayList<Reply>();
   public void addReply(Reply reply){
      replyList.add(reply);
      reply.setBoard(this);
   }
}
