package com.dobongnadlecoop.service;

import java.util.List;
import java.util.Map;

import org.springframework.validation.Errors;

import com.dobongnadlecoop.dto.BoardDataDTO;
import com.dobongnadlecoop.dto.BoardTitleDTO;

public interface NoticeBoardService {
	

	// 글 입력 유효성 에러메시지를 맵형태로 리턴해줍니다. valid_필드명 : 에러메세지
	public Map<String, String> validataHandling(Errors errors);

	// 글을 입력하는 서비스
	public void insertNoticeData(BoardDataDTO data);
	
	// 리스트에 뿌릴 글을 가져오는 서비스 (타이틀만, 페이지 사용)
	public List<BoardTitleDTO> getTitleList();

}
