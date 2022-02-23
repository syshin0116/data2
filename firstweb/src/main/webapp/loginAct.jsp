<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>

</head>
<body>
	<table>
		<tr>
			<td>아이디</td>
			<td><%=request.getParameter("u_id")%></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=request.getParameter("u_pw") %></td>
		</tr>
	</table>
</body>
</html>