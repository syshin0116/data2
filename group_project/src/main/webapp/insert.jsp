<%@page import="web.BoardDAO"%>
<%@page import="web.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 
    1. 클라이언트가 입력해서 서버로 보낸 데이터를 받아 주어야 함
    2. vo를 만들어서 데이터들을 넣어준다.
    3. vo주면서 dao에게 create 해달라고 요청한다.
    4. 결과 화면을 만들어서 클라이언트에게 보내준다.
     -->
    <%
    // 1. 클라이언트가 전송해준 데이터를 받기
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id"); // song
    String title = request.getParameter("title"); // 1111
    String context = request.getParameter("context"); // song song
	
    
    BoardVO boardVo = new BoardVO();
    boardVo.setId(id);
    boardVo.setTitle(title);
    boardVo.setContext(context);
    
  //ctrl+shift+m
    BoardDAO dao = new BoardDAO();
    dao.create(boardVo);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
alert('게시글이 등록되었습니다.');
location = "list.jsp";
</script>
</head>
<body>

</body>
</html>