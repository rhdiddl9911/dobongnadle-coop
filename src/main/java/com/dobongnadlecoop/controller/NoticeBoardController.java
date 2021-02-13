package com.dobongnadlecoop.controller;

import java.net.http.HttpRequest;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dobongnadlecoop.dto.BoardDataDTO;
import com.dobongnadlecoop.service.NoticeBoardService;
import com.dobongnadlecoop.utils.PageRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeBoardController {

	private final NoticeBoardService service;
	
	// /notice/ 입력시 /notice로 리다이렉트
	@GetMapping("/")
	public String ReturnHome() {
		return "redirect:/notice";
	}
	
	// 리스트
	@GetMapping("")
	public ModelAndView Home(final PageRequest pageable) {
		pageable.setSize(10);
		
		ModelAndView model = new ModelAndView("noticeboard/list");
		
		model.addObject("noticeBoardList", service.getTitleList(pageable.of()));
		
		return model;
	}

	// 글입력
	@PostMapping("")
	public ModelAndView insertNoticeBoardData(@Valid BoardDataDTO data, Errors errors, ModelAndView model) {
		
		// 유효성 검사 통과 실패
		if(errors.hasErrors()) {
			model.setViewName("/admin/noticeinsert");
			model.addObject("BoardData", data);
			
			Map<String, String> validResultMap = service.validataHandling(errors);
			
			for(String key : validResultMap.keySet()) {
				model.addObject(key, validResultMap.get(key));
			}
			return model;
		}
		
		// 유효성 검사 통과
		model.setViewName("redirect:/notice?page=1");
		service.insertNoticeData(data);
		
		return model;
	}
	
	// 글 보기
	@GetMapping("/{seq}")
	public ModelAndView showBoardDataDetail(@PathVariable int seq, ModelAndView model) {
		
		model.setViewName("/noticeboard/detail");
		
		Optional<BoardDataDTO> boradData = Optional.ofNullable(service.getBoardData(seq));
		
		if(boradData.isEmpty()) {
			model.setViewName("noitem");
		}else {
			model.addObject("BoardData", boradData.get());
		}
		
		return model;
	}
	
	// 글 삭제
	@DeleteMapping("/{seq}")
	public ModelAndView deleteBoardData(@PathVariable int seq, ModelAndView model) {
		service.deleteBoardData(seq);
		model.setViewName("redircet:/notice");
		return model;
	}
	
	
	// 글수정
	@PutMapping("/{seq}")
	public ModelAndView updateBoardData(@PathVariable int seq, @Valid @RequestBody BoardDataDTO data, Errors errors, ModelAndView model) {
		// 유효성 검사 통과 실패
		if(errors.hasErrors()) {
			model.setViewName("admin/noticeupdate");
			model.addObject("BoardData", data);
			
			Map<String, String> validResultMap = service.validataHandling(errors);
			
			for(String key : validResultMap.keySet()) {
				model.addObject(key, validResultMap.get(key));
			}
			return model;
		}
		
		// 검사 통과
		model.setViewName("redirect:/notice/"+data.getSeq());
		service.insertNoticeData(data);
		
		return model;
	}
}
