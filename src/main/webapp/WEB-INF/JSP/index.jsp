<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<title>Insert title here</title>
<%@include file="header_menu.jspf"%>

<link rel="stylesheet" href="/css/board.css">
<link rel="stylesheet" href="/css/index_home.css">
</head>
<body>
	<div class="imgslides">
		<div id="slides">
			<img src="/img/slide-1.jpg" />
			<img src="/img/slide-2.jpg" />
			<img src="/img/slide-3.jpg" />
			<img src="/img/slide-4.jpg" />
			<img src="/img/slide-5.png" />
		</div>
	</div>

	<div class="boardcontent">
	<div class="flexwrap">
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
					<tr onclick="location.href='notice/${boardData.seq}?page=1'" class="boarditem">
						<td>${boardData.title}</td>
						<td>${boardData.createdate}</td>
					</tr>
				</c:forEach>
			</c:if>

		</table>
		</div>
	</div>
	
	<div class="flexwrap">
		<h3 class="title">게시판</h3>
		<div class="board">
		<table>
			<tr>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>

			<c:if test="${commonBoardData != null}">
				<tr>
					<td colspan="3" id="nulldata">아직 데이터가 없습니다.</td>
				</tr>
			</c:if>

			<tr>
				<td>아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직
					데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직
					데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.</td>
				<td>dd</td>
				<td>dd</td>
			</tr>

			<tr>
				<td>아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직
					데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직
					데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.</td>
				<td>dd</td>
				<td>dd</td>
			</tr>

			<tr>
				<td>아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직
					데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직
					데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.</td>
				<td>dd</td>
				<td>dd</td>
			</tr>

			<tr>
				<td>아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직
					데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직
					데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.</td>
				<td>dd</td>
				<td>dd</td>
			</tr>

			<tr>
				<td>아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직
					데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.아직
					데이터가 없습니다.아직 데이터가 없습니다.아직 데이터가 없습니다.</td>
				<td>dd</td>
				<td>dd</td>
			</tr>

		</table>
		</div>
	</div>
	</div>

	<!-- slide Plugin -->
	<script src="/js/jquery.slides.min.js"></script>
	<script src="/js/img_slider.js"></script>

</body>
<%@include file="footer.jspf"%>
</html>