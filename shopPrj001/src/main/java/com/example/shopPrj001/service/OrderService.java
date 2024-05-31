package com.example.shopPrj001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopPrj001.Dto.OrderRequest;
import com.example.shopPrj001.Dto.OrderRequest.OrderItem;
import com.example.shopPrj001.domain.Product;
import com.example.shopPrj001.domain.Shoppingbasket;
import com.example.shopPrj001.repository.ProductRepository;
import com.example.shopPrj001.repository.ShoppingbasketRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShoppingbasketRepository shoppingbasketRepository;

    @Transactional
    public void processOrder(OrderRequest orderRequest) {
        List<OrderItem> orderItems = orderRequest.getOrderItems();

        for (OrderItem item : orderItems) {
            Product product = productRepository.findByPname(item.getPname())
                    .orElseThrow(() -> new RuntimeException("Product not found: " + item.getPname()));

            // 상품 수량 감소
            if (product.getPamount() < item.getAmount()) {
                throw new RuntimeException("Not enough stock for product: " + item.getPname());
            }
            product.setPamount(product.getPamount() - item.getAmount());
            productRepository.save(product);

            // 장바구니 데이터 삭제
            shoppingbasketRepository.deleteBySbno(item.getSbno());
        }
    }
}








