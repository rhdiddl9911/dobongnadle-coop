package com.dobongnadlecoop.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dobongnadlecoop.service.BoardService;
import com.dobongnadlecoop.service.impl.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	
	@Qualifier("notice")
	private final BoardService noticeService;
	private final CustomUserDetailsService memberService;
	
	@GetMapping("")
	public ModelAndView forAdmin() {
		ModelAndView model = new ModelAndView("admin/index");
		return model;
	}
	
	@GetMapping("/")
	public String ridect() {
		return "redirect:/admin";
	}

	@GetMapping("/notice")
	public ModelAndView insertNotice() {
		ModelAndView model = new ModelAndView("admin/noticeinsert");
		return model;
	}
	
	@GetMapping("/member")
	public ModelAndView memberList() {
		ModelAndView model = new ModelAndView("admin/memberList");
		model.addObject("memberList", memberService.getMemberList());
		return model;
	}
}
