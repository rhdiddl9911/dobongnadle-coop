package com.dobongnadlecoop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dobongnadlecoop.config.SecurityUser;
import com.dobongnadlecoop.domain.Member;
import com.dobongnadlecoop.dto.MemberDataDTO;
import com.dobongnadlecoop.repository.MemberRepository;
import com.dobongnadlecoop.utils.ModelMapperUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	
	private final MemberRepository memRepo;
	private final PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> optional = memRepo.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username+" 사용자 없음");
		}
		
		Member member = optional.get();
		if(member.isNotallow()) {
			System.out.println("승인 되지 않음");
			throw new UsernameNotFoundException(username+"승인 되지 않음");
		}
		return new SecurityUser(member);
	}
	
	public boolean singup(Member member) {
		member.setPassword(encoder.encode(member.getPassword()));
		member.setNotallow(true);
		memRepo.save(member);
		
		return true;
	}
	
	public List<MemberDataDTO> getMemberList(){
		return ModelMapperUtil.convertDataType(memRepo.findAll(), MemberDataDTO.class);
	}

}
