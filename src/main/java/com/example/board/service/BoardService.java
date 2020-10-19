package com.example.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	/*
	 * 게시판 삭제
	 */
	public int deleteBoard(int boardIdx) {
		boardRepository.deleteAll();	// 해당 인덱스 전부 삭제
		return 0;
	}

	/*
	 * 게시판 가져오기
	 */
	public Board getBoard(int boardId) {
		Optional<Board> board = boardRepository.findById(boardId);
		return board.get();
	}

	/*
	 * 게이판 삽입 ==> 존재하지 않는 idx값 일 때, insert
	 */
	public int insertBoard(Board board) {
		boardRepository.save(board);
		return board.getBoardIdx();	// int형식인 key값 return
	}

	/*
	 * 게시판 목록
	 */
	public List<Board> listBoard(){
		//String delYn = "N";
		//boardRepository.findByDelYn(delYn);
		//findByTitleAndDelYn(title,delYn);
		return (List<Board>) boardRepository.findAll();
	}

	/*
	 * 게시판 변경 ==> 보드 idx값이 같이 넘어오면 업데이트 됨 ==> idx가 존재하면 update
	 */
	public void updateBoard(Board board) {
		Optional<Board> optionalBoard = boardRepository.findById(board.getBoardIdx());
		if(optionalBoard.get()!=null) {
			optionalBoard.get().setContent(board.getContent());
			optionalBoard.get().setTitle(board.getTitle());
			optionalBoard.get().setUpdateDate("현재시간");
			optionalBoard.get().setUpdateId("kkk");
		}
		boardRepository.save(optionalBoard.get());	// 값이 존재하면 save한다.
	}
}
