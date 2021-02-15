package com.dobongnadlecoop.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.dobongnadlecoop.domain.NoticeBoard;
import com.dobongnadlecoop.dto.BoardDataDTO;
import com.dobongnadlecoop.dto.BoardTitleDTO;
import com.dobongnadlecoop.repository.NoticeBoardRepository;
import com.dobongnadlecoop.service.BoardService;
import com.dobongnadlecoop.utils.ModelMapperUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Qualifier("notice")
public class NoticeBoardService implements BoardService {

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
	public void insertBoardData(BoardDataDTO data) {
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
	
	@Override
	public void deleteBoardData(int seq) {
		repo.deleteById(seq);
	}
	
	@Override
	public void updateBoardData(BoardDataDTO data) {
		data.setUpdatedate(new Date());
		repo.save(ModelMapperUtil.convertDataType(data, NoticeBoard.class));
	}
	
}
