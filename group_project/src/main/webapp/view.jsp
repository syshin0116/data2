<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web.BoardDAO"%>
<%@page import="web.BoardVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
    // 1. 클라이언트가 전송해준 데이터를 받기
    request.setCharacterEncoding("utf-8");
    int idx = Integer.parseInt(request.getParameter("idx")); // song

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
<script>
    	function board_del(value, idx){
    		if(confirm(value+" 글을 정말로 삭제하시겠습니까?")){
    			location.href = "${contextPath}/delete.jsp?idx="+idx;
    		}
    	}
    </script>

</head>
<body>
<div class="container">
	<div class="section">
<h2>(${board.title})</h2>
<table class="bluetop">
			
				<tr>
				<th>No.</th>
				<td>${board.idx}</td>
				</tr>
				
				<tr>
				<th>아이디</th>
				<td>${board.id}</td>
				</tr>
				
				<tr>
				<th>title</th>
				<td>${board.title}</td>
				</tr>
				
				<tr>
				<th>context</th>
				<td>${board.context}</td>
				</tr>
				
				<tr>
				<th>수정일</th>
				<td>
				<fmt:formatDate value="${board.mdfydate}" pattern="yyyy-MM-dd hh:mm"/></td>
				</tr>
				
				<tr>
				<th>등록일</th>
				<td><fmt:formatDate value="${board.rgstdate}" pattern="yyyy-MM-dd hh:mm"/></td>
				</tr>
			</table>
			<div class="btns">
				<button class="btn_style_submit" onclick="location.href='${contextPath}/list.jsp'">게시판 목록</button>
				<button class="btn_style_edit" onclick="location.href='${contextPath}/mdfy.jsp?idx=${board.idx}'">수정</button>
				<button class="btn_style_delete" onclick="board_del('${board.title}', ${board.idx})">삭제</button>
			
			</div>
		</div>
	</div>

</body>
</html>