package com.dobongnadlecoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice")
public class NoticeBoardController {

	@GetMapping("/")
	public String ReturnHome() {
		return "redirect:/notice";
	}
	
	@GetMapping("")
	public ModelAndView Home() {
		ModelAndView model = new ModelAndView("noticeboard/list");
		
		return model;
	}
}
