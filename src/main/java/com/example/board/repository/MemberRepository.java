package com.example.board.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.board.entity.Member;

public interface MemberRepository extends CrudRepository<Member, String> {
	public Member findByMemIdAndMemPass(String memId, String memPass);
}
