package com.example.shopPrj001.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopPrj001.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
