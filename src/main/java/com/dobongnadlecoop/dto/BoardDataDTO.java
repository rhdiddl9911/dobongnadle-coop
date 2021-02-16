package com.dobongnadlecoop.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 글을 저장하거나 (1개) 유저 -> DB 
// 글을 불러올때 (1개) DB -> 유저 사용할 DTO입니다. NoticeBoard, Board 공용

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BoardDataDTO {
	
	private int seq;
	
	@NotEmpty(message = "제목을 입력해주세요")
	@NotBlank(message = "제목을 입력해주세요")
	@Length(max=200, message = "제목은 200자 이하로 입력해주세요.")
	private String title;
	
	@NotEmpty(message = "내용을 입력해 주세요")
	@NotBlank(message = "내용을 입력해 주세요")
	private String content;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Asia/Seoul")
	private Date createdate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Asia/Seoul")
	private Date updatedate;
	
}
