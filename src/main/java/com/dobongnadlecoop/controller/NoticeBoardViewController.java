package com.dobongnadlecoop.controller;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		public ModelAndView noticeHome(final PageRequest pageable, @RequestParam Optional<Integer> seq) {
			ModelAndView model = new ModelAndView("noticeboard/list");
			
			if(seq.isPresent()) {
				model.addObject("seq", seq.get());
			}
			
			return model;
		}
		
		// 공지클릭
		@GetMapping("/{seq}")
		public String noticeMainClick(@PathVariable int seq) {
			
			return "redirect:/notice";
		}
		
}
