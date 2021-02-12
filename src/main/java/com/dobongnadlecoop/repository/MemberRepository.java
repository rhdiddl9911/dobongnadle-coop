package com.dobongnadlecoop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dobongnadlecoop.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

}
