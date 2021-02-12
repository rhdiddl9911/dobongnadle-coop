package com.dobongnadlecoop.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dobongnadlecoop.domain.NoticeBoard;

@Repository
public interface NoticeBoardRepository extends JpaRepository<NoticeBoard, Integer>{

	<T> List<T> findAllBy(Class<T> projection, Pageable page);
}
