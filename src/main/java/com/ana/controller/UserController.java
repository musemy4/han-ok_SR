package com.ana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ana.domain.UserVO;
import com.ana.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/register/*")
@AllArgsConstructor
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/signIn")
	public String showPage() {
		return "/register/signIn";
	}
	
	@PostMapping("/checkEmail")
	public String checkEmail(String email, RedirectAttributes rttr) {
		log.info("email check: "+ email);
		if(service.checkEmail(email)) {
			rttr.addFlashAttribute("msg1", "해당 이메일을 사용하실 수 있습니다");
			
		} else {
			rttr.addFlashAttribute("msg1", "사용불가! 중복된 이메일이 있습니다");
		}
		rttr.addFlashAttribute("email", email);
		return "redirect:/register/signIn";
	}
	
	@PostMapping("/register")
	public String register(String uFstname, Model model) {
		model.addAttribute("uFstname", uFstname);
		return "register/welcome";
	}
		
}