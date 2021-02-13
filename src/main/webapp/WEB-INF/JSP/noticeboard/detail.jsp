<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 상세보기</title>
<%@include file="../header_menu.jspf" %>
</head>
<body>
	<h1>글 상세보기</h1>
	
	<h2>${BoardData.title}</h2>
	
	<p>${BoardData.content}</p>
	
	<sec:authorize access="hasRole('ADMIN')">

		<button onclick="location.href='/admin/notice/${BoardData.seq}'">수정</button>
	<form action="/notice/${BoardData.seq}">
		<button type="submit" formmethod="delete">삭제</button>
	</form>
	</sec:authorize>
	<c:if test="${param.page == null}">
		<c:set var="page" value=""/>
	</c:if>
	<c:if test="${param.page != null}">
		<c:set var="page" value="page=${param.page}"/>
	</c:if>
	<button onclick="location.href='/notice?${page}'">목록</button>
	
</body>
<%@include file="../footer.jspf" %>
</html>