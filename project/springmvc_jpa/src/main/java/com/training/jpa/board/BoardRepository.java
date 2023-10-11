package com.training.jpa.board;

import org.springframework.data.repository.Repository;

import com.training.jpa.board.entity.Board;
import java.util.List;


public interface BoardRepository extends Repository<Board, Long>{
   void save(Board board);
   void delete(Board board);
   Board findById(Long id);
}
