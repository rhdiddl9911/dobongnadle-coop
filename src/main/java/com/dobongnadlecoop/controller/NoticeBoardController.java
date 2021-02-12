package com.dobongnadlecoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dobongnadlecoop.service.NoticeBoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeBoardController {

	private final NoticeBoardService service;
	
	@GetMapping("/")
	public String ReturnHome() {
		return "redirect:/notice";
	}
	
	@GetMapping("")
	public ModelAndView Home() {
		ModelAndView model = new ModelAndView("noticeboard/list");
		
		model.addObject("noticeBoardList", service.getTitleList());
		
		return model;
	}
	
}
