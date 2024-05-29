package com.example.shopPrj001.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.shopPrj001.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query(value = "SELECT * FROM Product ORDER BY psales_rate DESC LIMIT 4", nativeQuery = true)
    List<Product> findTop4ByOrderByPsalesRateDesc();
}
