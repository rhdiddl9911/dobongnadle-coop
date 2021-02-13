package com.dobongnadlecoop.controller;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dobongnadlecoop.service.NoticeBoardService;
import com.dobongnadlecoop.utils.PageRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class HomeController {
	
	private final NoticeBoardService noticeService;
	
	@GetMapping("/")
	public ModelAndView HomeReturn() {
		ModelAndView model = new ModelAndView("index");
		
		PageRequest pageable = new PageRequest(1, 5, Direction.DESC);
		
		model.addObject("noticeBoardList", noticeService.getTitleList(pageable.of()).getContent());
		
		return model;
	}
	
}
