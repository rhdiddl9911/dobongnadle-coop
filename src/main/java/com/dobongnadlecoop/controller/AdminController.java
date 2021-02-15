package com.dobongnadlecoop.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dobongnadlecoop.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	
	@Qualifier("notice")
	private final BoardService noticeService;
	
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
	
	@GetMapping("/notice/{seq}")
	public ModelAndView updateNotice(@PathVariable int seq, ModelAndView model) {
		model.addObject("BoardData", noticeService.getBoardData(seq));
		model.setViewName("admin/noticeupdate");
		return model;
	}
	
}
