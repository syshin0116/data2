<%@page import="web.BoardVO"%>
<%@page import="web.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    // 1. 클라이언트가 전송해준 데이터를 받기
    request.setCharacterEncoding("utf-8");
    String idx = request.getParameter("idx"); // song
    String title = request.getParameter("title"); // 1111
    String context = request.getParameter("context"); // song song
	
    
    BoardVO boardVo = new BoardVO();
    boardVo.setTitle(title);
    boardVo.setIdx(Integer.parseInt(idx));
    boardVo.setContext(context);
    
  //ctrl+shift+m
    BoardDAO dao = new BoardDAO();
    dao.update(boardVo);
    %>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script>
alert('게시글이 수정 되었습니다.');
location = "list.jsp";
</script>
</html>