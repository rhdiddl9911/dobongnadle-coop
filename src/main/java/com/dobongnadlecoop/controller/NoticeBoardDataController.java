package com.dobongnadlecoop.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.dobongnadlecoop.dto.BoardTitleDTO;
import com.dobongnadlecoop.service.BoardService;
import com.dobongnadlecoop.utils.PageRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/noticeboard")
@RequiredArgsConstructor
public class NoticeBoardDataController {

	@Qualifier("notice")
	private final BoardService service;

	@GetMapping("/list")
	public @ResponseBody ResponseEntity<Page<BoardTitleDTO>> getList(final PageRequest pageable){
		pageable.setSize(10);
		
		try {
			Page<BoardTitleDTO> listItem = service.getTitleList(pageable.of());
			return new ResponseEntity<>(listItem, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Page<BoardTitleDTO>>(HttpStatus.ACCEPTED);
		}
		
	}
	// 글 상세 보기
	@GetMapping("/list/{seq}")
	public @ResponseBody ResponseEntity<BoardDataDTO> showBoardDataDetail(@PathVariable int seq) {
		Optional<BoardDataDTO> boradData = Optional.ofNullable(service.getBoardData(seq));
		
		if(boradData.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<>(boradData.get(), HttpStatus.OK);
		}
	}

	// 글입력
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/list")
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
		service.insertBoardData(data);
		
		return model;
	}
	
	
	// 글 삭제
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/list/{seq}")
	public @ResponseBody ResponseEntity<HttpStatus> deleteBoardData(@PathVariable int seq, ModelAndView model) {
		try{
			service.deleteBoardData(seq);
			return new ResponseEntity<HttpStatus>(HttpStatus.RESET_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
		}
	}
	
	
	// 글수정
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/list/{seq}")
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
		service.insertBoardData(data);
		
		return model;
	}
}
