package com.dobongnadlecoop.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.dobongnadlecoop.domain.Member;

public class SecurityUser extends User {
	private static final long serialVersionUID = 1L;
	private Member member;
	
	public SecurityUser(Member member) {
		
		super(member.getId(), member.getPassword(),
						AuthorityUtils.createAuthorityList(
								member.getMemberRole()!= null ?
										member.getMemberRole().toString() : "MEMBER"));
		
		this.member = member;
	}
	
	public Member getMember() {
		return member;
	}
}
