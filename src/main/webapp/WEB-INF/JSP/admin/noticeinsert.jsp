<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../header_menu.jsp" %>
</head>
<body>

<form action="/notice" method="post">
	<input type="text" placeholder="제목을 입력하세요" name="title" class="title" value="${BoardDataDTO.title}">
	<span>${valid_title}</span><br>
	<input type="text" placeholder="내용을 입력하세요" name="content" class="content" value="${BoardDataDTO.content}">
	<span>${valid_content}</span><br>
	<input type="submit" value="입력하기">
</form>

</body>
<%@include file="../footer.jsp" %>
</html>