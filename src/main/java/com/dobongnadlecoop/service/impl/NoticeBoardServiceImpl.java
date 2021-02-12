package com.dobongnadlecoop.service.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
