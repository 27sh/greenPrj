package com.example.shopPrj001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.shopPrj001.domain.Member;
import com.example.shopPrj001.repository.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/mem")
public class MemController {
	
	 @Autowired
	 private MemberRepository memberRepository;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	
	@RequestMapping("/regForm")
	public String regFrom() {
		
		return "member/regForm.html";
	}
	
    @GetMapping("/signUp")
    public String showSignUpForm(Model model) {
        model.addAttribute("member", new Member());
        return "signUp";
    }
	
    @PostMapping("/signUp")
	public String signUp(Member member, Model model) {
		String fullEmail = member.getMememail1() + "@" + member.getMememail2();
        member.setMememail(fullEmail);
        
        String fullPhone = member.getMemtel1() + member.getMemtel2();
        member.setMemtel(fullPhone);

        memberRepository.save(member);
        model.addAttribute("message", "회원가입이 완료되었습니다.");
		
        return "common/signUpSuccess.html";
	}
    
    @RequestMapping("/regMemidCheck")
    public @ResponseBody String regMemidCheck(@RequestParam("memid") String memid) {
        if (memid == null || memid.isEmpty()) {
            return "아이디를 입력해주세요.";
        }

        Member member = memberRepository.findByMemid(memid);
        if (member == null) {
            return "사용 가능합니다.";
        } else {
            return "이미 가입된 아이디입니다.";
        }
    }
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "member/loginForm.html";
	}
	
	@PostMapping("/login")
    public ModelAndView login(@RequestParam("memid") String memid, @RequestParam("mempw") String mempw, HttpSession session) {
        Member member = memberRepository.findByMemidAndMempw(memid, mempw);
        ModelAndView mav = new ModelAndView();

        if (member != null) {
            session.setAttribute("member", member);
            mav.setViewName("redirect:/mem/index");  // 로그인 성공 후 리다이렉트할 페이지 설정
        } else {
            mav.setViewName("member/loginForm");
            mav.addObject("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
        }

        return mav;
    }
	
	@RequestMapping("/index")
	public String memberIndex() {
		
		return "member/memIndex.html";
	}
	
}
