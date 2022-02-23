<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <% out.println("헬로우 JSP 월드~~~"); %>
 <ul>
 <% for(int i=0;i<5;i++){ %>
 	<li><%out.println(i+1);%></li>
 	<%} %>
 </ul>
 
</body>
</html>