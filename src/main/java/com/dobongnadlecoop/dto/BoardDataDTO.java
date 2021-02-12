package com.dobongnadlecoop.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 글을 저장하거나 (1개) 유저 -> DB 
// 글을 불러올때 (1개) DB -> 유저 사용할 DTO입니다. NoticeBoard, Board 공용

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDataDTO {

	private int seq;
	private String title;
	private String content;
	private Date createdate;
	private Date updatedate;
	
}
