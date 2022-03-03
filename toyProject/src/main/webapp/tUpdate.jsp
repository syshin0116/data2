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
		$.ajax({
			dataType : "json",
			url : "tTime",
			data : {
				mvId : ${param.mvId} /* a태그 get으로 받아온 ${mvId} 들어가는 부분 */
			},
			success : function(result) {
				for (key in result) {
					console.log(result[key])
					$('#d1')
							.append(
									"<button class='tButton' onclick='seatChoice(${param.mvId},"
											+ result[key] + ")' id='" + key
											+ "' value='" + result[key] + "'>"
											+ (parseInt(result[key]))
											+ ":00</button> ")//append
					//seatChoice 함수 안에 mvId값 넣어주기
				}//for문
			},//success
			error : function() {
				alert('실패.@@@')
			}//error:
		})//$ajax

		/* $(document).on("click",".tButton",function(time){	
		}) */

	})//$function
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
		<div id='center'>
			<%
				if (session.getAttribute("mId") == null) {
			%>
			<h3>먼저 로그인을 해주세요.</h3>
			<%
				} else {
			%>
			<h3>시간 선택</h3>
			<div id=d1></div>
			<h3>좌석 선택</h3>
			<div id=d2></div>
			<%
				}
			%>
		</div>
	</div>
</body>
<script>
	function seatChoice(id, time) /* a태그 get으로 받아온 ${mvId} 들어가는 부분 */
	{
		console.log(time)
		$.ajax({
			url : "tSeat2",
			data : {
				tId : ${param.tId},
				mvId : id,
				tTime : time
				
			},
			success : function(result) {
				for (key in result) {
					$('#d2').html(result)
				}
			},
			error : function() {
				alert('실패.@@@')
			}
		})
	}
</script>
</html>