package com.dobongnadlecoop.service;

import java.util.List;

import com.dobongnadlecoop.dto.BoardDataDTO;
import com.dobongnadlecoop.dto.BoardTitleDTO;

public interface NoticeBoardService {

	// 글을 입력하는 서비스
	public void insertNoticeData(BoardDataDTO data);
	
	// 리스트에 뿌릴 글을 가져오는 서비스 (타이틀만, 페이지 사용)
	public List<BoardTitleDTO> getTitleList();

}
