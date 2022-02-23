<%@page import="java.util.List"%>
<%@page import="web.BoardDAO"%>
<%@page import="web.BoardVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    	<%
    	request.setCharacterEncoding("utf-8");
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> list = boardDAO.board_list(); 
		
		request.setAttribute("board_list", list);

    	%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css"/>

</head>
<body>
<div class="container">
	<div class="section">
	<h2>게시판</h2>
			<table class="bluetop">
				<tr>
					<td>No</td>
					<td>아이디</td>
					<td>제목</td>
					<td>수정일</td>
					<td>등록일</td>
				</tr>
				<c:forEach var="board" items="${board_list}" varStatus="status">
				<tr>
					<td>${board.idx}</td>
					<td>${board.id}</td>
					<td><a href="${contextPath}/view.jsp?idx=${board.idx}">${board.title}</a></td>
					<td><fmt:formatDate value="${board.mdfydate}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${board.rgstdate}" pattern="yyyy-MM-dd"/></td>
				</tr>
				</c:forEach>
			</table>
			<button class="btn_style_submit" onclick="location.href='${contextPath}/create.jsp'">글작성</button>
			
	</div>
</div>
</body>
</html>