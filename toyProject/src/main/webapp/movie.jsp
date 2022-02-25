<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url : "mvList", //views/movieList.jsp가 결과
			success: function(result) { //결과가 담겨진 table부분코드
				$('#d1').html(result)
			},
			error: function() {
				alert('실패')
			}
		})
	})
</script>
<title>상영 영화</title>
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
			<h3>상영 영화</h3>
			<hr color="red">
			<div id="d1"></div> 
		</div>
	</div>
</body>
</html>