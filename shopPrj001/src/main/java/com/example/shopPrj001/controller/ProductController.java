package com.example.shopPrj001.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shopPrj001.domain.Product;
import com.example.shopPrj001.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String listProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productList", productList);
        return "admin/manageProduct.html";
    }
    
    @GetMapping("/products/add")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "admin/productForm.html";
    }

    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }
    
    @GetMapping("/products/edit/{pno}")
    public String showEditForm(@PathVariable("pno") Long pno, Model model) {
        Product product = productService.getProductById(pno);
        model.addAttribute("product", product);
        return "admin/productEdit.html";
    }
    
    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }
    
    @PostMapping("/products/delete/{pno}")
    public String deleteProduct(@PathVariable("pno") Long pno) {
        productService.deleteProduct(pno);
        return "redirect:/admin/products";
    }
    
    

}
