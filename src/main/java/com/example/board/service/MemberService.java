package com.example.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	// 회원 정보 저장
	public String insertMember(Member member) {
		memberRepository.save(member);
		return member.getMemId();
	}

	// 회원 정보 가져오기
	public Member getMemeber(String memId, String memPass) {
		Member member = memberRepository.findByMemIdAndMemPass(memId,memPass);
		if(member!=null) {
			return member;
		} else {
			return null;
		}

	}
}
