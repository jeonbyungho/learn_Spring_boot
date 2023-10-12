package com.training.jpa.board;

import org.springframework.stereotype.Component;

import com.training.jpa.board.boardmvc.BoardService;
import com.training.jpa.board.form.BoardForm;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TestInit {
   private final BoardService boardService;
   
   @PostConstruct
   public void init(){
      for(int i=0; i <502; i++){
         BoardForm b = new BoardForm();
         b.setTitle("가상 게시판" + i);
         b.setAuthor("un");
         b.setContent("아무런 내용이 없습니다.");
         boardService.writeBoard(b);
      }
   }
}
