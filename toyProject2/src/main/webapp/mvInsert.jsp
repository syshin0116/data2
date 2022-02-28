<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 추가 페이지</title>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	
</script>

</head>
<body>
	<div id="total">
		<div id="top">
			<jsp:include page="top.jsp"></jsp:include>
		</div>
		<div id="top2">
			<jsp:include page="top2.jsp"></jsp:include>
		</div>
		<div id="center">
		<span style="font-size: 25px;">영화 추가 페이지
			<% if(session.getAttribute("mId") == "root") { %> (관리자모드)<%} %></span>
			<hr color=red>
			<form action="mvIn">
				영화제목: <input type="text" class="form-control" name="mvTitle"><br>
				상영시간: <input type="text" class="form-control" name="mvTime"><br>
				상영관: <input type="text" class="form-control" name="mvSection"><br>
				평점: <input type="text" class="form-control" name="mvRating"><br>
				줄거리: <textarea rows="10" cols="30" class="form-control" name="mvSummary"></textarea><br>
				포스터 img 주소: <input type="text" class="form-control" name="mvImg"><br>
				<button type="submit" class="btn btn-success">영화등록</button>
			</form>
		</div>
	</div>
</body>
</html>