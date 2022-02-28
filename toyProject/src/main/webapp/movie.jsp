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
			success : function(result) { //결과가 담겨진 table부분코드
				$('#d1').html(result)
			},
			error : function() {
				alert('실패')
			}
		})
	})
</script>
<title>상영 영화</title>
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
			<h3>
				상영 영화 ${mId} 
				<%if(session.getAttribute("mId")!=null){
				if (session.getAttribute("mId").equals("root")) {
			%>
				(관리자모드) <a href="mvInsert.jsp"><button id="insertBtn">영화
						추가</button></a>
			</h3>

			<%
				}
				}
			%>
			<hr color="red">
			<div id="d1"></div>
		</div>
	</div>
</body>
</html>