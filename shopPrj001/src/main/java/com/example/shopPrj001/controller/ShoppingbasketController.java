package com.example.shopPrj001.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addToBasket(@PathVariable("pno") Long pno, HttpSession session,
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

                // 성공적인 응답 데이터 생성
                Map<String, Object> response = Map.of(
                    "pname", product.getPname(),
                    "sbamount", shoppingBasket.getSbamount(),
                    "sbprice", shoppingBasket.getSbprice()
                );

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(404).body(Map.of("error", "상품을 찾을 수 없습니다."));
            }
        }

        return ResponseEntity.status(401).body(Map.of("error", "로그인이 필요합니다."));
    }
	
    @DeleteMapping("/deleteProduct/{pno}")
    @ResponseBody
    public ResponseEntity<Void> deleteProduct(@PathVariable("pno") Long pno) {
        try {
            shoppingBasketService.deleteProductByPno(pno);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
