package com.training.jpa.board.boardmvc;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.training.jpa.board.entity.Board;
import com.training.jpa.board.form.BoardForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
   
   private final BoardService boardService;
   
   // 페이지
   @GetMapping("/board/{boardId}")
   public String getBoard(@PathVariable Long boardId, Model model){
      Board board = boardService.getBoardById(boardId);
      if(board == null){
         return "redirect:/";
      }

      model.addAttribute("board", board);
      return "board/post";
   }

   // 작성
   @GetMapping("/board/write")
   public String getWriteBoard(@ModelAttribute BoardForm boardForm){
      return "board/write";
   }

   @PostMapping("/board/write")
   public String submitBoard(@ModelAttribute BoardForm boardForm){
      Board board = boardService.writeBoard(boardForm);
      return "redirect:/board/" + board.getId();
   }

   //목록
   @GetMapping("/board/list/{pageNumber}")
   public String pagingBoardList(@PathVariable Integer pageNumber, Model model){
      Page<Board> boardPage = boardService.BoardListPage(pageNumber - 1);
      List<Board> list = boardPage.toList();
      int totalPage = boardPage.getTotalPages();
      
      model.addAttribute("boardList", list);
      model.addAttribute("totalPage", totalPage);
      return "board/list";
   }

   @GetMapping("/board/list")
   public String pagingBoardList(Model model){
      return pagingBoardList(1, model);
   }
}
