package com.training.jpa.board.boardmvc;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import com.training.jpa.board.entity.Board;
import java.util.List;

public interface BoardRepository extends Repository<Board, Long>{
   //insert
   Board save(Board board);
   //delete
   void delete(Board board);

   // select where id
   Board findById(Long id);
   // select
   List<Board> findAll();

   Page<Board> findAll(Pageable pageable);
}
