package com.training.jpa.board;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.jpa.board.entity.Board;
import com.training.jpa.board.entity.Post;
import com.training.jpa.board.form.BoardForm;

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
            .build())
         .build();
      
      Board board2 = Board.builder()
         .title("미작성 페이지")
         .post(Post.builder()
            .content("이런 내용물")
            .dateCreated(LocalDateTime.now())
            .build())
         .build();
      
      boardService.writeBoard(board);
      boardService.writeBoard(board2);

      Board findBoard = boardService.getBoardById(2L);
      System.out.println("find " + findBoard.toString());
   }

   // 페이지
   @GetMapping("/board/{boardId}")
   public String boardLookup(@PathVariable Long boardId, Model model){
      Board board = boardService.getBoardById(boardId);
      if(board == null){
         return "redirect:/";
      }

      model.addAttribute("board", board);
      return "board/post";
   }

   // 작성
   @GetMapping("/board/write")
   public String writeBoardPage(@ModelAttribute BoardForm boardForm){
      return "board/write";
   }

   @PostMapping("/board/write")
   public String submitBoard(@ModelAttribute BoardForm boardForm){
      Board board = Board.builder()
         .title(boardForm.getTitle())
         .post(Post.builder()
            .author(boardForm.getAuthor())
            .content(boardForm.getContent())
            .dateCreated(LocalDateTime.now())
            .build())
         .build();
      board = boardService.writeBoard(board);
      return "redirect:/board/" + board.getId();
   }

   //목록
   @GetMapping("/board/list")
   public String boardList(Model model){
      List<Board> list = boardService.boardFindAll();
      System.out.println("총 게시글 : " + list.size());
      System.out.println(list.toString());
      model.addAttribute("boardList", list);
      return "board/list";
   }
}
