<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" href="css/main.css">

<header>
<div class="wrap">
	<div class="inner">
	<div class="logo">
	<a href="/"><img src="img/logo.jpg">
	<strong>도봉 나들가게 협동 조합</strong></a>
	</div>
	
		<nav id="menu">
			<ul>
				<li><a href="/"><strong>홈</strong></a></li>
				<li><a href="#1"><strong>소개</strong></a></li>
				<li><a href="/notice"><strong>공지사항</strong></a></li>
				<li><a href="#3"><strong>게시판</strong></a></li>
				<li><a href="#4"><strong>갤러리</strong></a></li>
				
				
				<li id="loginmenu">
					<sec:authorize access="isAnonymous()">
						<a href="/login">로그인</a>
					</sec:authorize>
					
					<sec:authorize access="hasRole('ADMIN')">
					<a href="/admin">관리자</a>
					</sec:authorize>
					
					<sec:authorize access="isAuthenticated()">
					<a href="">내정보</a>
					</sec:authorize>
					
					<sec:authorize access="isAuthenticated()">
						<a href="/logout">로그아웃</a>
					</sec:authorize>
				</li>
			</ul>
		</nav>
		
	</div>
</div>
</header>

<script src="js/jquery-3.5.1.js"></script>
<script src="js/scroll_menu_event.js"></script>

<div class="wrap main">
	<div class="inner">

