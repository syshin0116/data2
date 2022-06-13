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
<link rel="stylesheet" type="text/css" href="resources/css/project.css">
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	
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
			<jsp:include page="../../top.jsp"></jsp:include>
		</div>
		<div id="memberTop">
			<jsp:include page="../../mTop.jsp"></jsp:include>
		</div>
		<div id="center">
							<span style="font-size: 25px;">리뷰 수정 페이지</span>
			<hr color=red>
			<div id="mvImg" style="float: left; width: 20%; text-align: center;">
				<img src="${one.mvImg}" style="width: 90%">
			</div>
			<form action="rUpdate2">
				<label for="rRating">평점 : </label> <select class="form-control"
						id="rRating" name="rRating">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				<div class="form-group">
					<label for="rComment">감상평 : </label> 					
					<textarea rows="5" cols="5" class="form-control" name="rComment"
						style="background: yellow; color: green; font-weight: bold;"
					>${one.rComment}</textarea>
				</div>
				<div class="form-group">
					<input type="hidden" name="rId"
						 value="${one.rId}">
				</div>
				<button type="submit" class="btn btn-success">수정하기</button>
			</form>
		</div>
	</div>
</body>
</html>