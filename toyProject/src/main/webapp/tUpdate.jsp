<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function() {
		console.log('테스트')
		$.ajax({
			url : "tList",
			data : {
				mId : ${mId}
			},
			success : function(result) {
				$('#d1').html(result)
			},
			error : function() {
				alert('실패.@@@')
			}
		})
	})
</script>
<link rel="stylesheet" type="text/css" href="resources/css/project.css">
</head>
<body>
	<div id='total'>
		<div id="menu">
			<jsp:include page="top.jsp"></jsp:include>
		</div>
		<div id="memberTop">
			<jsp:include page="mTop.jsp"></jsp:include>
		</div>
		<span style="font-size: 25px;">리뷰 작성 페이지</span>
		<hr color=red>
		<div id="mvImg" style="float: left; width: 20%; text-align: center;">
			<img src="${mvImg}" style="width: 90%">
		</div>
		<jsp:include page="top2.jsp"></jsp:include>
	</div>
	<div id='center'>
		<%
			if (session.getAttribute("userId") != null) {
		%>
		<h3>먼저 로그인을 해주세요.</h3>
		<%
			} else {
		%>
		<div id=d1></div>
		<%
			}
		%>
	</div>
	</div>
</body>
</html>