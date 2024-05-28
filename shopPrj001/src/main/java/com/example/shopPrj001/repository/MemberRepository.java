package com.example.shopPrj001.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopPrj001.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	Member findByMemid(String memid);
	//회원가입
	
	Member findByMemidAndMempw(String memid, String mempw);
	//로그인
}
