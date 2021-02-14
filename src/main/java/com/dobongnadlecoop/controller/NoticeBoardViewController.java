package com.dobongnadlecoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dobongnadlecoop.utils.PageRequest;

@Controller
@RequestMapping("/notice")
public class NoticeBoardViewController {
	
	// /notice/ 입력시 /notice로 리다이렉트
		@GetMapping("/")
		public String ReturnHome() {
			return "redirect:/notice";
		}
		
		// 리스트
		@GetMapping("")
		public ModelAndView Home(final PageRequest pageable) {
			ModelAndView model = new ModelAndView("noticeboard/list");
			
			// 글가져올
			model.addObject("dataUrl", "/noticeborad/list");
			model.addObject("method", "GET");
			
			return model;
		}
		
		// 글 보기
		@GetMapping("/{seq}")
		public ModelAndView showBoardDataDetail(@PathVariable int seq, ModelAndView model) {
			model.setViewName("noticeboard/detail");
			
			// 글 가져올
			model.addObject("dataUrl", "/noticeboard/list/"+seq);
			model.addObject("method","GET");
			
			return model;
		}
		
}
