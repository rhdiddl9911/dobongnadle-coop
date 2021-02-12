package com.dobongnadlecoop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class NoticeBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	
	@Column(nullable = false)
	private String title;
	
	@Lob
	@Column(nullable = false)
	private String content;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable=false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", nullable = false)
	private Date createdate;
		
	@Column(insertable = false)
	private Date updatedate;	// 마지막 글 수정 시각
	
}
