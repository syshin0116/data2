<%@page import="web.BoardVO"%>
<%@page import="web.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%
    // 1. 클라이언트가 전송해준 데이터를 받기
    int idx = Integer.parseInt(request.getParameter("idx")); // song
    request.setCharacterEncoding("utf-8");
    BoardDAO boardDAO = new BoardDAO();
    BoardVO boardVo = boardDAO.board_view(idx);
    request.setAttribute("board", boardVo);
  //ctrl+shift+m
    
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보</title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css"/>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script>
function update() {
		if(confirm("수정하시겠습니까?")) {
			$('#frmBoard').submit();
		}
	}

</script>
</head>
<body>
<div class="container">
	<div class="section">
<h2>${board.title}글 수정하기</h2>
<form action="${contextPath}/update.jsp" method="post" id="frmBoard">
<input type="hidden" name="idx" id="idx" value="${board.idx}">
<table class="bluetop">
			
				
				<tr>
				<th>아이디</th>
				<td>${board.id}</td>
				</tr>
				
				<tr>
				<th>제목</th>
				<td><input type="text" id= "title" name="title"></td>
				</tr>
				
				<tr>
				<th>내용</th>
				<td><textarea name="context" id="context" rows="50" cols="110"></textarea></td>
				</tr>
				
				
				
			</table>
			</form>
			<div class="btns">
				<button class="btn_style_edit" onclick="update()">수정하기</button>
			</div>
		</div>
	</div>

</body>
</html>