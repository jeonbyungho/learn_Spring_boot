package com.training.jpa.board.boardmvc;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
      Sort sort = Sort.by("id").descending();
      Page<Board> page = boardRepository.findAll(PageRequest.of(pageNumber, 10, sort));
      return page;
   }

   @Transactional
   public Page<Board> BoardListPage(int pageNumber, String title){
      String q = "%" + title + "%";
      System.out.println(q);
      Sort sort = Sort.by("id").descending();
      Page<Board> page = boardRepository.findByTitleLike(q, PageRequest.of(pageNumber, 10, sort));
      return page;
   }
}
