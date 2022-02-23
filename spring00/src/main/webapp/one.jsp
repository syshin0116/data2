
<%@page import="web.MemberVO"%>
<%@page import="web.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id = request.getParameter("id");
	MemberVO vo = new MemberVO();
	vo.setId(id);
	
	MemberDAO dao = new MemberDAO();
	MemberVO vo2 = dao.readOne(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(vo2.getId() !=null) {%>
검색한 id는 <%= vo2.getId() %> <br>
검색한 pw는 <%= vo2.getPw() %> <br>
검색한 name은 <%= vo2.getName() %> <br>
검색한 tel은 <%= vo2.getTel() %> <br>
<%}else{%>
<h1 style=color:red >검색결과가 없습니다.</h1>
<%}%>
</body>
</html>