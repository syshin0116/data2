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
<div id="center">
			<form action="mUpdate">
				<div class="idChange">
					<label for="id">ID:</label> 
					<input type="text"
						class="form-control" name="mId" value="${one.mId}">
				</div>
				<div class="pwChange">
					<label for="pw">PW:</label> 					
					<input type="text"
						class="form-control" name="mPw" value="${one.mPw}">
				</div>
				<div class="emailChange">
					<label for="email">EMAIL:</label> 					
					<input type="text"
						class="form-control" name="mEmail" value="${one.mEmail}">
				</div>
				<div class="phoneChange">
					<label for="phone">PHONE:</label> 					
					<input type="text"
						class="form-control" name="mPhone" value="${one.mPhone}">
				</div>
				<button type="submit" class="btn btn-success">수정하기</button>
			</form>
		</div>

</body>
</html>