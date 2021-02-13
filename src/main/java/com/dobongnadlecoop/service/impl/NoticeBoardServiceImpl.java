package com.dobongnadlecoop.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<BoardTitleDTO> getTitleList(Pageable pageable) {
		return repo.findAllBy(BoardTitleDTO.class, pageable);
	}
	
	@Override
	public BoardDataDTO getBoardData(int seq) {
		
		Optional<NoticeBoard> findresult = repo.findById(seq);
		
		if(findresult.isEmpty()) {
			return null;
		}else {
			return ModelMapperUtil.convertDataType(findresult.get(), BoardDataDTO.class);
		}
	}
	
}
