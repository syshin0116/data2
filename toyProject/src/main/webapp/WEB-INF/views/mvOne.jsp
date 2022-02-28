<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화상세정보</title>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#deleteBtn').click(function(){
			if(confirm("정말로 삭제하시겠습니까?")){
				//controller의 mvDel요청 후, 삭제가 성공하면, mv.jsp로 화면을 넘김
				$.ajax({
					url: "mvDel",
					data: {
						mvId: ${one.mvId}	
					},
					success : function(result) {
						if(result == '1'){
							alert("삭제되었습니다")
							location.href = "movie.jsp"
						}
					}//success
				})//ajax
			}//confirm
		})//Btn
	})//$function
</script>
</head>
<body>
	<div id="total">
		<div id="menu">
			<jsp:include page="../../top.jsp"></jsp:include>
		</div>
		<div id="memberTop">
			<jsp:include page="../../mTop.jsp"></jsp:include>
		</div>
		<div id="center">
			<span style="font-size: 25px;">영화 상세 페이지
			<% if(session.getAttribute("mId").equals("root")) { %> (관리자모드)<%} %></span>
			<hr color=red>
			<div id="mvImg" style="float: left; width: 20%; text-align: center;">
				<img src="${one.mvImg}" style="width: 90%">
			</div>
			<div id="mvOne">
				<p>영화제목: ${one.mvTitle}</p>
				<p>상영시간: ${one.mvTime}</p>
				<p>상영관: ${one.mvSection}</p>
				<p>평점: ${one.mvRating}</p>
				<p>정보: ${one.mvSummary}</p>
				<button id="ticketBtn" onclick="location.href='tInsert.jsp?mvId=${one.mvId}'">예매</button>
				<button id="reviewBtn" onclick="location.href='review.jsp?mvId=${one.mvId}'">리뷰</button>
				<% if(session.getAttribute("mId").equals("root")) { %>
				<button id="oneBtn" onclick="location.href='mvUp?mvId=${one.mvId}'">수정</button>
				<button id="deleteBtn">삭제</button>
				<%} %>
			</div>
		</div>
	</div>
</body>
</html>