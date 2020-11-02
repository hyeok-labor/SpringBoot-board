package com.example.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.board.util.DateUtil;

/**
 * @author hyeok
 *
 */
@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	//	게시판 목록
	public List<Board> listBoard(){
		//		String delYn = "N";
		//		boardRepository.findByDelYn(delYn);

		return (List<Board>) boardRepository.findAll();
	}

	// 게시판 1건 가져오기
	public Board getBoard(int boardId) {
		Optional<Board> board = boardRepository.findById(boardId);
		if(board.get()!=null) {
			Board bd = board.get();
			bd.setHitCnt(board.get().getHitCnt()+1);
			boardRepository.save(bd);
		}
		return board.get();
	}

	//	게시물 삽입
	public int insertBoard(Board board) {
		board.setHitCnt(0);
		board.setDelYn("N");
		board.setUpdateDate(DateUtil.getCurrentDate());

		boardRepository.save(board);
		return board.getBoardIdx();
	}

	//	게시판 변경
	public void updateBoard(Board board) {
		Optional<Board> boardTmp = boardRepository.findById(board.getBoardIdx());
		if (boardTmp.get() != null) {
			boardTmp.get().setContent(board.getContent());
			boardTmp.get().setTitle(board.getTitle());
			boardTmp.get().setUpdateDate(DateUtil.getCurrentDate());
			//boardTmp.get().setUpdateId("kkkkk");
			boardRepository.save(boardTmp.get());
		}

	}

	// 게시판 삭제
	public void deleteBoard(int boardIdx) {
		boardRepository.deleteById(boardIdx);
	}
}

