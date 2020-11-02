package com.example.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.entity.Board;
import com.example.board.service.BoardService;

/**
 * @author hyoek
 * 2020. 10. 26.
 * @return
 */
@Controller
public class MainController {
	@Autowired
	private BoardService boardService;

	// html 파일명과 일치 해야한다.!!!!
	@RequestMapping("/board/list")
	public ModelAndView listBoard(){
		ModelAndView mv = new ModelAndView("/board/list");

		List<Board> list = boardService.listBoard();
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/board/detail")
	public ModelAndView boardDetail(Board board){
		ModelAndView mv = new ModelAndView("/board/detail");
		int boardIdx = board.getBoardIdx();
		Board board2 = boardService.getBoard(boardIdx);
		mv.addObject("board",board2);
		return mv;
	}

	@RequestMapping("/board/boardWrite")
	public String boardWrite() {
		return "/board/boardWrite";
	}

	@RequestMapping("/board/insertBoard")
	public String insertBoard(Board board) {
		int boardIdx = boardService.insertBoard(board);

		System.out.println("boardIdx >>>" + boardIdx+" board created");

		return "redirect:/board/list";
	}

	@RequestMapping("/board/deleteBoard")
	public String deleteBoard(Board board) {

		int boardIdx = board.getBoardIdx();
		System.out.println(boardIdx);
		if(boardIdx>0) {
			boardService.deleteBoard(boardIdx);
		}

		return "redirect:/board/list";
	}

	@RequestMapping("/board/updateBoard")
	public String udateBoard(Board board) {

		boardService.updateBoard(board);

		return "redirect:/board/list";
	}
}
