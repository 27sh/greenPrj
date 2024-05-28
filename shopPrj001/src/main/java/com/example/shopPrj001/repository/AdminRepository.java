package com.example.shopPrj001.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopPrj001.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>{
	
	Admin findByAdidAndAdpw(String adid, String adpw);
	//로그인
}
