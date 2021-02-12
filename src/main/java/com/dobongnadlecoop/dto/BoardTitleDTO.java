package com.dobongnadlecoop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

// 내용빼고 타이틀만 가져올 DTO 추후에 updatedate도 가져올지 고민.

@AllArgsConstructor
@Data
public class BoardTitleDTO {

	private int seq;
	private String title;
	private Date createdate;
	
}
