package com.dobongnadlecoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dobongnadlecoop.domain.Member;
import com.dobongnadlecoop.service.impl.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
	
	private final CustomUserDetailsService service;
	
	@GetMapping("")
	public ModelAndView loginView() {
		ModelAndView model = new ModelAndView("login");
		return model;
	}

	@GetMapping("/signup")
	public ModelAndView singupView() {
		ModelAndView model = new ModelAndView("signup");
		return model;
	}
	
	@PostMapping("/signup")
	public ModelAndView singupDo(Member member, @RequestParam("passwordcheck")String passwordcheck) {
		ModelAndView model = new ModelAndView("signup_ok");
		
		if(!member.passcheck(passwordcheck)) {
			model.setViewName("signup");
			return model;
		}
		
		service.singup(member);
		
		return model;
	}
	
}
