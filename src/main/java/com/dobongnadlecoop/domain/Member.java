package com.dobongnadlecoop.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode(of= {"id"})
@Entity
@ToString
public class Member {

	@Id
	private String id;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String memo;
	@Enumerated(EnumType.STRING)
	private MemberRole memberRole;
	private boolean notallow;
	
	public boolean passcheck(String passwordcheck) {
		if(password.equals(passwordcheck)) {
			return true;
		}else {
			return false;
		}
	}
}
