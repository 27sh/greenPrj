package com.example.shopPrj001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shopPrj001.domain.Member;
import com.example.shopPrj001.domain.Product;
import com.example.shopPrj001.domain.Shoppingbasket;
import com.example.shopPrj001.service.ProductService;
import com.example.shopPrj001.service.ShoppingBasketService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/mem")
public class ProductMemberController {

	private final ProductService productService;

    public ProductMemberController(ProductService productService) {
        this.productService = productService;
    }
    
	@Autowired
    private ShoppingBasketService shoppingBasketService;

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productList", productList);
        return "member/productList.html";
    }
    
    @GetMapping("/product/detail/{pno}")
    public String showProductDetail(@PathVariable("pno") Long pno, Model model) {
        Product product = productService.getProductById(pno);
        model.addAttribute("product", product);
        return "member/productDetail.html";
    }
    
    @RequestMapping("/shopping")
    public String listShopping(HttpSession session, Model model) {
        Member member = (Member) session.getAttribute("member");
        if (member == null) {
            // 회원 정보가 없으면 로그인 페이지로 리디렉션
            return "redirect:/login";
        }
        
        String memid = member.getMemid();
        List<Shoppingbasket> basketList = shoppingBasketService.getAllProductsByMemberId(memid);
        model.addAttribute("basketItems", basketList);
        return "member/shopping.html"; // 확장자 없이 반환
    }
}
