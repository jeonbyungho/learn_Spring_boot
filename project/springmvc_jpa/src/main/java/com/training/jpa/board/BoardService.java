package com.training.jpa.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.jpa.board.entity.Board;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
   
   private final BoardRepository boardRepository;

   @Transactional
   public Board writeBoard(Board board){
      return boardRepository.save(board);
   }

   @Transactional
   public Board getBoardById(Long id){
      return boardRepository.findById(id);
   }

   @Transactional
   public List<Board> boardFindAll(){
      return new ArrayList<Board>(boardRepository.findAll());
   }
}
