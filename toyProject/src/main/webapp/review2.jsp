<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function() {
		// alert('test...');
		$.ajax({
			url : "rList2", //views/rList.jsp가 결과!
			success : function(result) { //결과가 담겨진 table부분코드
				$('#d1').html(result);
			},
			error : function() {
				alert('실패.@@@');
			}
		});
	});
</script>
<style>
td {
	background: white;
	height: 30px;
}
</style>
</head>
<body>
	<div id="total">
		<div id="menu">
			<jsp:include page="top.jsp"></jsp:include>
		</div>
		<div id="memberTop">
			<jsp:include page="mTop.jsp"></jsp:include>
		</div>
		<div id="center">
			<h3>리뷰 목록</h3>
			<hr color="red">

			<%
				if (session.getAttribute("mId") != null) {
			%>
			<a href="rInsert.jsp">
				<button style="width: 100px; height: 50px;" class="btn btn-success">리뷰작성</button>
			</a>
			<%
				}
			%>
			<hr>
			<div id="d1"></div>
		</div>
	</div>
</body>
</html>