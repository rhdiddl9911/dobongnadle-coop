package com.dobongnadlecoop.userService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dobongnadlecoop.config.SecurityUser;
import com.dobongnadlecoop.domain.Member;
import com.dobongnadlecoop.repository.MemberRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberRepository memRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> optional = memRepo.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username+" 사용자 없음");
		}else {
			Member member = optional.get();
			return new SecurityUser(member);
		}
	}

}
