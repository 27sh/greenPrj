package com.example.shopPrj001.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shopPrj001.domain.Product;
import com.example.shopPrj001.service.ProductService;

@Controller
@RequestMapping("/mem")
public class ProductMemberController {

	private final ProductService productService;

    public ProductMemberController(ProductService productService) {
        this.productService = productService;
    }

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
}
