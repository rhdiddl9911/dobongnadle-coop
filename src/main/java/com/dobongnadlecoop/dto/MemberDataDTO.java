package com.dobongnadlecoop.dto;

import com.dobongnadlecoop.domain.MemberRole;

import lombok.Data;

@Data
public class MemberDataDTO {

	private String id;
	private String name;
	private String email;
	private String phone;
	private String memo;
	private MemberRole memberRole;
	private boolean notallow;
	
}
