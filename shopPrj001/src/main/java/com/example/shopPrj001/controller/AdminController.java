package com.example.shopPrj001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopPrj001.domain.Admin;
import com.example.shopPrj001.repository.AdminRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@RequestMapping("index")
	public String index() {
		
		return "admin/adminIndex.html";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "admin/adminLoginForm.html";
	}
	
	@PostMapping("/login")
    public ModelAndView login(@RequestParam("adid") String adid, @RequestParam("adpw") String adpw, HttpSession session) {
        Admin admin = adminRepository.findByAdidAndAdpw(adid, adpw);
        ModelAndView mav = new ModelAndView();

        if (admin != null) {
            session.setAttribute("admin", admin);
            mav.setViewName("redirect:/admin/index");  // 로그인 성공 후 리다이렉트할 페이지 설정
        } else {
            mav.setViewName("admin/loginForm");
            mav.addObject("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
        }

        return mav;
    }
	
	@RequestMapping("/manageP")
	public String manage() {
		
		return "admin/manageProduct.html";
	}
	
}
