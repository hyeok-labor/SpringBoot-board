package com.example.board.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.board.entity.Member;

/**
 * @author hyeok
 *
 */
public interface MemberRepository extends CrudRepository<Member, String> {



}
