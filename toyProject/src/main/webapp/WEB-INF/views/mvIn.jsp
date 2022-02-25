<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	
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
			<p>게시물 등록이 완료되었습니다.</p>
			<hr color="red">
			<a href="bbsOne?id=${id}">
				<button style="width: 200px; height: 50px;" class="btn btn-success">작성한 글확인</button>
			</a> <a href="bbs.jsp">
				<button style="width: 200px; height: 50px;" class="btn btn-success">목록보기</button>
			</a> <a href="bbsInsert.jsp">
				<button style="width: 200px; height: 50px;" class="btn btn-success">글쓰기</button>
			</a>
		</div>
	</div>
</body>
</html>