package com.dobongnadlecoop.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dobongnadlecoop.dto.BoardDataDTO;
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
	public ModelAndView Home(BoardDataDTO data) {
		ModelAndView model = new ModelAndView("noticeboard/list");
		
		model.addObject("noticeBoardList", service.getTitleList());
		
		return model;
	}

	@PostMapping("")
	public ModelAndView insertNoticeBoard(@Valid BoardDataDTO data, Errors errors, ModelAndView model) {
		
		if(errors.hasErrors()) {
			model.setViewName("/admin/noticeinsert");
			model.addObject("BoardDataDTO", data);
			
			Map<String, String> validResultMap = service.validataHandling(errors);
			
			for(String key : validResultMap.keySet()) {
				model.addObject(key, validResultMap.get(key));
			}
			return model;
		}
		
		model.setViewName("redirect:/notice");
		service.insertNoticeData(data);
		
		return model;
	}
	
}
