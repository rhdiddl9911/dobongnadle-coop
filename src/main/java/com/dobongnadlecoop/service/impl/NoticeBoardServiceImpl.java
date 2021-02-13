package com.dobongnadlecoop.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.dobongnadlecoop.domain.NoticeBoard;
import com.dobongnadlecoop.dto.BoardDataDTO;
import com.dobongnadlecoop.dto.BoardTitleDTO;
import com.dobongnadlecoop.repository.NoticeBoardRepository;
import com.dobongnadlecoop.service.NoticeBoardService;
import com.dobongnadlecoop.utils.ModelMapperUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{

	private final NoticeBoardRepository repo;
	
	@Override
	public Map<String, String> validataHandling(Errors errors) {
		Map<String, String> result = new HashMap<String, String>();
		
		for(FieldError error : errors.getFieldErrors()) {
			String validErrorFieldName = String.format("valid_%s", error.getField());
			result.put(validErrorFieldName, error.getDefaultMessage());
		}
		return result;
	}
	
	@Override
	public void insertNoticeData(BoardDataDTO data) {
		repo.save(ModelMapperUtil.convertDataType(data, NoticeBoard.class));
	}
	
	@Override
	public List<BoardTitleDTO> getTitleList() {
		// TODO Auto-generated method stub
		Pageable page = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
		return repo.findAllBy(BoardTitleDTO.class, page);
	}
	
}
