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
	
	<h2>${BoardData.getTitle()}</h2>
	
	<p>${BoardData.getContent()}</p>
	
	<sec:authorize access="hasRole('ADMIN')">
		<button>수정</button>
		<button>삭제</button>
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