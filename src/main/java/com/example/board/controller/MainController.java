package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;

@Controller
public class MainController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/")
	public String hello() {
		return "/";
	}
	// 자세히보기 ==> cnt++
	@RequestMapping("/board/detail")
	public Board board(int boardIdx) {
		return boardService.getBoard(boardIdx);
	}

	@RequestMapping("/board/list")
	public List<Board> boardList() {
		return boardService.listBoard();
	}



}
