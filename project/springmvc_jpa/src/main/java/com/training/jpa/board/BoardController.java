package com.training.jpa.board;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;

import com.training.jpa.board.entity.Board;
import com.training.jpa.board.entity.Post;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
   
   private final BoardService boardService;

   @PostConstruct
   public void testingInti(){
      Board board = Board.builder()
         .title("가상 제목")
         .post(Post.builder()
            .content("내용물")
            .dateCreated(LocalDateTime.now())
            .build()
         ).build();
      System.out.println(board.toString());
      Board board2 = Board.builder()
         .title("메타버스 제목").build();
      
      boardService.writeBoard(board);
      boardService.writeBoard(board2);

      Board findBoard = boardService.getBoardById(2L);
      System.out.println(findBoard.toString());
   }
}
