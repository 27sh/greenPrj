package com.example.shopPrj001.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shopPrj001.domain.Product;
import com.example.shopPrj001.repository.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
    
    public Product getProductById(Long pno) {
        return productRepository.findById(pno).orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + pno));
    }
    
    public void deleteProduct(Long pno) {
        productRepository.deleteById(pno);
    }

}
