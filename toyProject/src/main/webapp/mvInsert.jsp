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
			<jsp:include page="top.jsp"></jsp:include>
		</div>
		<div id="top2">
			<jsp:include page="top2.jsp"></jsp:include>
		</div>
		<div id="center">
			<form action="mvIn">

				mvTitle: <input type="text" class="form-control" name="mvTitle">
				mvTime: <input type="text" class="form-control" name="mvTime">
				mvSection: <input type="text" class="form-control" name="mvSection">
				mvRating: <input type="text" class="form-control" name="mvRating">
				mvSummary: <textarea rows="5" cols="5" class="form-control" name="mvSummary"></textarea>
				mvImg: <input type="text" class="form-control" name="mvImg">
				<button type="submit" class="btn btn-success">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>