package com.dobongnadlecoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
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
	
}
