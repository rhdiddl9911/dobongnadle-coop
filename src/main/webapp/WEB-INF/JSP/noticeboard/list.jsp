<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<%@include file="../header_menu.jspf" %>
<link rel="stylesheet" href="css/board.css"/>
</head>
<body>

<div class="boardwrap">
	<h3 class="title">공지사항</h3>
		
	<div class="board notice">
	
	<table>
		<tr>
			<th>제목</th>
			<th>작성일</th>
		</tr>
	
		<c:set var="list" value="${noticeBoardList.content}"/>
		
		<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="2" id="nulldata">아직 데이터가 없습니다.</td>
			</tr>
		</c:if>
		
		<c:if test="${list.size() > 0}">
			<c:forEach var="boardData" items="${list}">
				<tr onclick="location.href='notice/${boardData.seq}?page=${noticeBoardList.number+1}'" class="boarditem">
					<td><c:out value="${boardData.title}"/></td>
					<td><c:out value="${boardData.createdate}"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	</div>
	<div class="pagenation">
	<c:forEach var="page" begin="1" end="${noticeBoardList.getTotalPages()}">
		<a href="?page=${page}"><c:out value="${page}"/></a>
	</c:forEach>
	</div>
</div>


</body>
<%@include file="../footer.jspf" %>
</html>