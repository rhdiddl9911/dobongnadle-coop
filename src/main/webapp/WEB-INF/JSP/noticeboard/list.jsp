<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<%@include file="../header_menu.jsp" %>
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

			<c:if test="${noticeBoardList.size() == 0}">
				<tr>
					<td colspan="2" id="nulldata">아직 데이터가 없습니다.</td>
				</tr>
			</c:if>
			
			<c:if test="${noticeBoardList.size() > 0}">
				<c:forEach var="boardData" items="${noticeBoardList}">
					<tr onclick="location.href='notice/${boardData.seq}'" class="boarditem">
						<td>${boardData.title}</td>
						<td>${boardData.createdate}</td>
					</tr>
				</c:forEach>
			</c:if>

		</table>
		</div>
	</div>


</body>
<%@include file="../footer.jsp" %>
</html>