package com.example.shopPrj001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shopPrj001.domain.Product;
import com.example.shopPrj001.domain.Shoppingbasket;
import com.example.shopPrj001.repository.MemberRepository;
import com.example.shopPrj001.repository.ProductRepository;
import com.example.shopPrj001.repository.ShoppingbasketRepository;

@Service
public class ShoppingBasketService {

    @Autowired
    private ShoppingbasketRepository shoppingBasketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MemberRepository memberRepository;

    public void saveShoppingBasket(Shoppingbasket shoppingbasket) {
    	shoppingBasketRepository.save(shoppingbasket);
    }
    
    public List<Shoppingbasket> getAllProducts() {
        return shoppingBasketRepository.findAll();
    }
    
    public List<Shoppingbasket> getAllProductsByMemberId(String memid) {
        return shoppingBasketRepository.findByMemberMemid(memid);
    }
    
    public void deleteProductByPno(Long pno) {
        shoppingBasketRepository.deleteById(pno);
    }
}