package com.example.board.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.board.entity.Board;

/**
 * @author hyeok
 *
 */
public interface BoardRepository extends CrudRepository <Board, Integer>{
	public List<Board> findByDelYn(String delYn);
	public List<Board> findByTitleOrDelYn(String title, String delYn);

}
