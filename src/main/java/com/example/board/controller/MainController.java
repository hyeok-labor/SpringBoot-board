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


	@RequestMapping("/board/list")
	public ModelAndView listBoard(){
		ModelAndView mv = new ModelAndView("/board/list");

		List<Board> list = boardService.listBoard();
		mv.addObject("list", list);
		return mv;
	}
	@RequestMapping("/board/detail")
	public Board listBoard(int boardIdx){
		return boardService.getBoard(boardIdx);
	}
}
