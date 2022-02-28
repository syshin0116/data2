<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/css/project.css">
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
	$('#del').click(function() {
		if(confirm("정말로 삭제하시겠습니까?")){
			//controller의 bbsDel요청 후,
			//삭제가 성공하면, 
			//bbs.jsp로 화면을 넘기면 됨
			$.ajax({
				url: "rDelete",
				data: {
					rId: ${one.rId}
				},
				success : function(result) {
					if(result == '1'){
						location.href = "review2.jsp"
					}
				}
			});
		}
	});
});
</script>
<style>
.left {
	background: pink;
	width: 50px;
}

.right {
	background: white;
	width: 150px;
}
</style>
</head>
<body>
	<div id="total">
		<div id="menu">
			<jsp:include page="../../top.jsp"></jsp:include>
		</div>
		<div id="memberTop">
			<jsp:include page="../../mTop.jsp"></jsp:include>
		</div>
		<%--<div id="center">
			<span style="font-size: 25px;">게시물 상세 페이지</span>
			<hr color=red> --%>

		<a href="review2.jsp">
			<button style="width: 200px; height: 50px;" class="btn btn-success">게시물
				전체 목록으로!</button>
		</a>
		<!-- 로그인한 사람과 작성자가 동일하면
				수정, 삭제 버튼을 나타나게 해주자.
				세션값과 one.writer가 동일하면!!
			 -->
					<span style="font-size: 25px;">리뷰 상세페이지</span>
			<hr color=red>
			<div id="mvImg" style="float: left; width: 20%; text-align: center;">
				<img src="${one.mvImg}" style="width: 90%">
			</div>
		<c:if test="${mId eq one.mId}">
			<a href="rUpdate?rId=${one.rId}">
				<button style="width: 200px; height: 50px;" class="btn btn-success">수정하기</button>
			</a>
			<button id="del" style="width: 200px; height: 50px;"
				class="btn btn-success">삭제하기</button>

		</c:if>

		<hr color=red>
		<table width="500px">
			<tr>
				<td class="left">번호</td>
				<td class="right">${one.rId}</td>
				<!-- one.getId() -->
			</tr>
			<tr>
				<td class="left">영화제목</td>
				<td class="right">${one.mvId}</td>
			</tr>
			<tr>
				<td class="left">감상평</td>
				<td class="right" style="height: 100px;">${one.rComment}</td>
			</tr>
			<tr>
				<td class="left">평점</td>
				<td class="right">${one.rRating}</td>
			</tr>
			<tr>
				<td class="left">작성자</td>
				<td class="right">${one.mId}</td>
			</tr>
		</table>
		<hr color=green>
	</div>
	</div>
</body>
</html>