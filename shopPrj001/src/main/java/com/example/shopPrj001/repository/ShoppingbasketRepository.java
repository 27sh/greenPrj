package com.example.shopPrj001.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopPrj001.domain.Shoppingbasket;

public interface ShoppingbasketRepository extends JpaRepository<Shoppingbasket, Long> {

	List<Shoppingbasket> findByMemberMemid(String memid);
}