package com.example.shopPrj001.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopPrj001.domain.Member;
import com.example.shopPrj001.domain.Product;
import com.example.shopPrj001.domain.Shoppingbasket;
import com.example.shopPrj001.repository.ProductRepository;
import com.example.shopPrj001.service.ShoppingBasketService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/basket")
public class ShoppingbasketController {

	@Autowired
    private ShoppingBasketService shoppingBasketService;
	
	@Autowired
    private ProductRepository productRepository;

	@PostMapping("/add-to-basket/{pno}")
	public ResponseEntity<String> addToBasket(@PathVariable("pno") Long pno, HttpSession session,
	                                          @RequestBody Map<String, Object> requestData) {
	    Member member = (Member) session.getAttribute("member");

	    if (member != null) {
	        Product product = productRepository.findById(pno).orElse(null);
	        if (product != null) {
	            Shoppingbasket shoppingBasket = new Shoppingbasket();
	            shoppingBasket.setMember(member);
	            shoppingBasket.setProduct(product);
	            shoppingBasket.setSbamount(Long.valueOf(requestData.get("sbamount").toString()));
	            shoppingBasket.setSbprice(Long.valueOf(requestData.get("sbprice").toString()));

	            shoppingBasketService.saveShoppingBasket(shoppingBasket);
	            return ResponseEntity.ok("상품이 장바구니에 추가되었습니다.");
	        } else {
	            return ResponseEntity.status(404).body("상품을 찾을 수 없습니다.");
	        }
	    }

	    return ResponseEntity.status(401).body("로그인이 필요합니다.");
	}
	
	@RequestMapping("/shopping")
	public String listShopping(Model model) {
		List<Shoppingbasket> basketList = shoppingBasketService.getAllProducts();
		model.addAttribute("basketItems", basketList);
		return "member/shopping.html";
	}
}
