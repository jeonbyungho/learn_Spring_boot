package com.training.jpa.board.boardmvc;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.training.jpa.board.entity.Board;
import com.training.jpa.board.form.BoardForm;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
   
   private final BoardService boardService;
   protected final Logger logger = LoggerFactory.getLogger(getClass());
   private static final int PAGESIZE = 10;
   
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
   public String pagingBoardList(
         @PathVariable Integer pageNumber, 
         @RequestParam(required = false) String search,
         Model model){
      logger.info("검색한 단어━━" + search);
      
      Page<Board> boardPage = StringUtils.hasText(search) ? 
         boardService.BoardListPage(pageNumber - 1, search): 
         boardService.BoardListPage(pageNumber - 1);
      List<Board> boardToList = boardPage.toList();
      
      int startPage = pageNumber > PAGESIZE? (pageNumber-1)/PAGESIZE * PAGESIZE : 1;
      int lastPage = startPage + PAGESIZE;
      int totalPage = boardPage.getTotalPages();
      lastPage = lastPage > totalPage ? totalPage : lastPage;

      model.addAttribute("boardList", boardToList);
      model.addAttribute("startPage", startPage);
      model.addAttribute("lastPage", lastPage);
      logger.info("startPage"+ startPage);
      logger.info("lastPage"+ lastPage);
      logger.info("totalPage"+ totalPage);
      return "board/list";
   }

   @GetMapping("/board/list")
   public String pagingBoardList(
         @RequestParam(required = false) String search,
         Model model){
      return pagingBoardList(1, search, model);
   }
   
}
