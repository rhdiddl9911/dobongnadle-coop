package com.dobongnadlecoop.dbcon;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dobongnadlecoop.dto.BoardDataDTO;
import com.dobongnadlecoop.dto.BoardTitleDTO;
import com.dobongnadlecoop.service.NoticeBoardService;

@SpringBootTest
public class NoticeBoardDBTest {

	@Autowired
	private NoticeBoardService service;
	
	// dto를 사용하여  noticeboard에 insert하는 테스트입니다.
	@Test
	public void insertTest() {
		BoardDataDTO insertdata = new BoardDataDTO();
		insertdata.setTitle("테스트용 입력입니다.");
		insertdata.setContent("테스트용 내용 입력입니다. 긴 내용 내용 내용 ㅇ내용");
		
		service.insertNoticeData(insertdata);
		
		List<BoardTitleDTO> list = service.getTitleList();
		
		for (BoardTitleDTO data : list) {
			System.out.println(data.toString());
		}
	}
}
