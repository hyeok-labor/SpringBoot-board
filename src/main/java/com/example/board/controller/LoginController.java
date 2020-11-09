package com.example.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.board.entity.Member;
import com.example.board.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {
	@Autowired
	private MemberService memberService;

	@GetMapping("/login")
	public String login() {
		return "/login";
	}

	@RequestMapping(value="/loginSubmit", method = RequestMethod.POST)
	public String loginSubmit(Member member, Model model) {
		Member member2 = memberService.getMemeber(member.getMemId(),member.getMemPass());
		if(member2!=null) {
			model.addAttribute("member",member2);
			return "redirect:/board/list";
		}else{
			return "redirect:/login";
		}
	}
}
