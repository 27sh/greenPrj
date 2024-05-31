package com.example.shopPrj001.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopPrj001.domain.Shoppingbasket;

public interface ShoppingbasketRepository extends JpaRepository<Shoppingbasket, Long> {

	List<Shoppingbasket> findByMemberMemid(String memid);
	
	Optional<Shoppingbasket> findByProductPnameAndSbamount(String pname, Long sbamount);

	Optional<Shoppingbasket> findByProductPname(String pname);
	
	Optional<Shoppingbasket> findById(Long id);
	
	void deleteBySbno(Long sbno);
}