package com.dobongnadlecoop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Builder
@Entity
public class NoticeBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	
	@Column(nullable = false)
	private String title;
	
	@Lob
	@Column(nullable = false)
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false, updatable=false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", nullable = false)
	private Date createdate;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = false)
	private Date updatedate;	// 마지막 글 수정 시각

	@Builder
	public NoticeBoard(int seq, String title, String content, Date updatedate) {
		this.seq = seq;
		this.title = title;
		this.content = content;
		this.updatedate = updatedate;
	}
}
