package com.training.jpa.board.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@SequenceGenerator(name = "reply_seq_generator", sequenceName = "reply_seq"
                  ,initialValue = 1, allocationSize = 1)
@Getter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Reply {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE
                  , generator = "reply_seq_generator")
   @Column(name = "reply_id")
   private Long id;
   
   @ManyToOne
   @JoinColumn(name = "board_id")
   private Board board;
   public void setBoard(Board board){
      this.board = board;
   }

   @Embedded
   private Post post;
}
