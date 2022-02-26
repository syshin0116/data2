<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function() {
		$('#updateBtn').click(function() {
			if (confirm("정말로 수정하시겠습니까?")) {
				$('#frmMovieUpdate').submit();
			}
		})//Btn
	})
</script>

</head>
<body>
	<div id="total">
		<div id="top">
			<jsp:include page="../../top.jsp"></jsp:include>
		</div>
		<div id="top2">
			<jsp:include page="../../top2.jsp"></jsp:include>
		</div>
		<div id="center">
			<span style="font-size: 25px;">영화 상세 페이지 <%
				if (session.getAttribute("mId") == "root") {
			%> (관리자모드)<%
				}
			%></span>
			<hr color=red>
			<div id="mvImg" style="float: left; width: 20%; text-align: center;">
				<img src="${one.mvImg}" style="width: 90%">
			</div>
			<form id="frmMovieUpdate" action="mvUp2" method="post">
				<input type="hidden" name="mvId" id="mvId" value="${one.mvId}">
				<table class="bluetop">
					<tr>
						<th>제목:</th>
						<td><input type="text" name="mvTitle" id="mvTitle"
							value="${one.mvTitle}"></td>
					</tr>
					<tr>
						<th>상영시간:</th>
						<td><input type="text" name="mvTime" id="mvTime"
							value="${one.mvTime}"></td>
					</tr>
					<tr>
						<th>상영관:</th>
						<td><input name="mvSection" id="mvSection"
							value="${one.mvSection}"></input></td>
					</tr>
					<tr>
						<th>평점:</th>
						<td><input name="mvRating" id="mvRating"
							value="${one.mvRating}"></input></td>
					</tr>
					<tr>
						<th>줄거리:</th>
						<td><textarea rows="10" cols="30" id="mvSummary"
								name="mvSummary">${one.mvSummary}</textarea></td>
					</tr>
					<tr>
						<th>포스터:</th>
						<td><input name="mvImg" id="mvImg" value="${one.mvImg}"></input></td>
					</tr>
				</table>
				<button type="submit" id="updateBtn">수정</button>
			</form>
			<button onclick="location.href='mvOne?mvId=${one.mvId}'">이전
				페이지</button>
		</div>
	</div>
</body>
</html>