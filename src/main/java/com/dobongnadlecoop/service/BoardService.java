package com.dobongnadlecoop.service;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;

import com.dobongnadlecoop.dto.BoardDataDTO;
import com.dobongnadlecoop.dto.BoardTitleDTO;

public interface BoardService {

	// 유효성 검사 에러메세지 핸들링하기
	Map<String, String> validataHandling(Errors errors);

	// 테이블에 테이터 넣기
	void insertBoardData(BoardDataDTO data);

	// 리스트 반환
	Page<BoardTitleDTO> getTitleList(Pageable pageable);

	// 글하나 얻기
	BoardDataDTO getBoardData(int seq);

	// 글 하나 삭제
	void deleteBoardData(int seq);

	// 글 하나 수정
	void updateBoardData(BoardDataDTO data);

}