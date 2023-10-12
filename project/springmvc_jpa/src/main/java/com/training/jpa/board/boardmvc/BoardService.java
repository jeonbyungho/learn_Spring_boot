package com.training.jpa.board.boardmvc;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.jpa.board.entity.Board;
import com.training.jpa.board.entity.Post;
import com.training.jpa.board.form.BoardForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
   
   private final BoardRepository boardRepository;

   @Transactional
   public Board writeBoard(BoardForm boardForm){
      Board board = Board.builder()
         .title(boardForm.getTitle())
         .post(Post.builder()
            .author(boardForm.getAuthor())
            .content(boardForm.getContent())
            .dateCreated(LocalDateTime.now())
            .build())
         .build();
      return boardRepository.save(board);
   }

   @Transactional
   public Board getBoardById(Long id){
      return boardRepository.findById(id);
   }

   @Transactional
   public Page<Board> BoardListPage(int pageNumber){
      Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("id").descending());
      Page<Board> page = boardRepository.findAll(pageable);
      return page;
   }

   @Transactional
   public Page<Board> BoardListPage(int pageNumber, String title){
      String str = String.format("%s%s%s", "%",title,"%");
      Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("id").descending());
      Page<Board> page = boardRepository.findByTitleLike(str, pageable);
      return page;
   }
}
