package com.dobongnadlecoop.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dobongnadlecoop.domain.NoticeBoard;

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Integer>{

	<T> Page<T> findAllBy(Class<T> projection, Pageable page);
}
