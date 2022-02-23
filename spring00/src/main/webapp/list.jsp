<%@page import="web.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	MemberDAO dao = new MemberDAO();
	ArrayList<MemberVO> list = dao.readAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(MemberVO vo2:list){
%>
검색한 id는 <%= vo2.getId() %><br>
검색한 name는 <a href="one.jsp?id=<%= vo2.getId() %>"><%= vo2.getName() %></a><br>
<hr>
<%
	}
%>
</body>
</html>