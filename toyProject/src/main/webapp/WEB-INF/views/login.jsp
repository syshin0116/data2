<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link 	rel="stylesheet" 
		type="text/css" 
		href="resources/css/project.css" > -->
</head>
<body>
	<div id="center">
			<form action="check">
					<table>
					<tr>
						<td class="left">아이디</td>
						<td class="right"><input  class="form-control input-lg"  type="text" name="mId"></td>
					</tr>
					<tr>
						<td class="left">패스워드</td>
						<td class="right"><input  class="form-control input-lg"  type="text" name="mPw"></td>
					</tr>
					<tr>
						<td colspan="2">
						<button  style="width:200px; height:50px;" class="btn btn-success" type="submit">로그인</button>
						</td>
						<td colspan="2">
						
						</td>
					</tr>
				</table>
			</form>
			<button  style="width:200px; height:50px;" class="btn btn-danger" type="submit" onclick="location.href='mRegister'">회원가입하기</button>
			</div>
</body>
</html>