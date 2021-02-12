<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

			<c:if test="${noticeBoardData == null}">
				<tr>
					<td colspan="2" id="nulldata">아직 데이터가 없습니다.</td>
				</tr>
			</c:if>

		</table>
		</div>
	</div>


</body>
<%@include file="../footer.jsp" %>
</html>