package com.example.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepository;

	@Test
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("1st content");
		board.setContent("this is content.");
		board.setCreateDate("2020-10-19");
		board.setWriteName("hyeok");
		board.setCreateId("part1shb");
		board.setHitCnt(1);

		boardRepository.save(board);
		System.out.println("board updated!!");

	}
}
