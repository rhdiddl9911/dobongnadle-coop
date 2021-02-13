package com.dobongnadlecoop.utils;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public final class PageRequest {

	private int page = 1;
	private int size = 5;
	private Sort.Direction direction = Direction.DESC;
	
	public void setPage(int page) {
		this.page = page < 0 ? 1 : page;
	}
	
	public void setSize(int size) {
		int DEFAULT_SIZE = 5;
		int MAX_SIZE = 20;
		this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
	}
	
	public void setDirection(Sort.Direction direction) {
		this.direction = direction;
	}
	
	public org.springframework.data.domain.PageRequest of(){
		return org.springframework.data.domain.PageRequest.of(page - 1, size, direction, "seq");
	}
}
