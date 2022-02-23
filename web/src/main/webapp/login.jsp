<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href=${contextPath}/css/style.css>
</head>
<body>

<div class="container">
<div class="section">
<h2>로그인 페이지</h2>
	<form action="login" method="post" name="frmlogin">
		<table class="bluetop">
		<tr>
				<td>아이디</td>
				<td><input type="text" name="user_id"></td>
		</tr>
		<tr>
				<td>비밀번호</td>
				<td><input type="password" name="user_pw"></td>
		</tr>
		</table>
		<button class="btn_style_submit">로그인</button>
		<button type = "button" class="btn_style_submit" onclick="location='memberWrite'">회원가입</button>
	</form>
	</div>
	</div>
</body>
</html>



