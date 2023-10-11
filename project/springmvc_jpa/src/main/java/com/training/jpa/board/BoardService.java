package com.training.jpa.board;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.jpa.board.entity.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
   
   private final BoardRepository boardRepository;

   @Transactional
   public void writeBoard(Board board){
      boardRepository.save(board);
   }

   @Transactional
   public Board getBoardById(Long id){
      return boardRepository.findById(id);
   }
}
