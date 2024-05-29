package com.example.shopPrj001.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopPrj001.domain.Shoppingbasket;

public interface ShoppingbasketRepository extends JpaRepository<Shoppingbasket, Long> {
	
}