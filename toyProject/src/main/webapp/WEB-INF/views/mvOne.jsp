<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#updateBtn').click(function() {
			
		})
		$('#deleteBtn').click(function(){
			if(confirm("정말로 삭제하시겠습니까?")){
				//controller의 bbsDel요청 후,
				//삭제가 성공하면, 
				//bbs.jsp로 화면을 넘기면 됨
				$.ajax({
					url: "mvDel",
					data: {
						mvId: ${one.mvId}	
					},
					success : function(result) {
						/* 
						int x = 100;
						String y = "100";
						== : 기본 데이터형만 가능 
						*/
						//js: 타입이 달라도 기본형과 String까지 비교 가능
						/* 
						x = 100
						y = '100'
						x == y 타입이 달라도 비교 가능 
						x === y 타입이 동일해야 같다고 판단하는 비교 가능. */
						
						if(result == '1'){
							location.href = "movie.jsp"
						}
					}
				})
			}
		
		})
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
			<span style="font-size: 25px;">영화 상세 페이지
			<% if(session.getAttribute("mId") == "root") { %> (관리자모드)<%} %></span>
			<hr color=red>
			<div id="mvImg" style="float: left; width: 20%; text-align: center;">
				<img src="${one.mvImg}" style="width: 90%">
			</div>
			<div id="mvOne">
				<p>영화제목: ${one.mvTitle}</p>
				<p>상영시간: ${one.mvTime}</p>
				<p>상영관: ${one.mvSection}</p>
				<p>평점: ${one.mvRating}</p>
				<p>줄거리: ${one.mvSummary}</p>
				<button id="ticketBtn">예매</button>
				<button id="reviewBtn">리뷰</button>
				<% if(session.getAttribute("mId") == "root") { %>
				<button id="updateBtn">수정</button>
				<button id="deleteBtn">삭제</button>
				<%} %>
			</div>
		</div>
	</div>
</body>
</html>