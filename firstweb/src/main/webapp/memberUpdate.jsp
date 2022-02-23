<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="firstweb.DataBase"%>

<% 
	request.setCharacterEncoding("utf-8");
	String m_idx= request.getParameter("m_idx");
	String m_pw= request.getParameter("m_pw");
	String m_name= request.getParameter("m_name");
	String m_email= request.getParameter("m_email");
	String m_phone= request.getParameter("m_phone");
	
	Connection con = null;
	PreparedStatement pstmt= null;
	String query="";
	
	DataBase database = new DataBase();
	con = database.getConnection();
	
	query = "UPDATE member SET m_pw=?, m_name=?, m_email=?, m_phone=?, m_mdfydate=now() WHERE m_idx=?";
	pstmt = con.prepareStatement(query);
	pstmt.setString(1, m_pw);
	pstmt.setString(2, m_name);
	pstmt.setString(3, m_email);
	pstmt.setString(4, m_phone);
	pstmt.setInt(5, Integer.parseInt(m_idx));
	
	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
%>
<script>
alert('회원정보가 수정되었습니다.');
location = "memberView.jsp?m_idx=<%=m_idx%>";
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>

</body>
</html>