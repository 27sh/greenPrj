package com.example.shopPrj001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shopPrj001.Dto.OrderRequest;
import com.example.shopPrj001.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
    @Autowired
    private OrderService orderService;
	
	@RequestMapping("/orderForm")
	public String orderForm() {
		
		return "member/order.html";
	}
	
	@RequestMapping("/complete")
	public String complete() {
		
		return "member/completePayment.html";
	}
	
	@PostMapping("/completeProc")
    public String completeOrder(@RequestBody OrderRequest orderRequest, Model model) {
        try {
            orderService.processOrder(orderRequest);
            return "redirect:/order/complete";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "member/orderError";  // 오류 페이지 템플릿 이름
        }
    }
}
