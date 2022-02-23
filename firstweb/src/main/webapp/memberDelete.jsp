<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="firstweb.DataBase"%>

<% 
	request.setCharacterEncoding("utf-8");
	String m_idx= request.getParameter("m_idx");
	//String m_name= request.getParameter("m_name");
	String m_name="";
	
	Connection con = null;
	PreparedStatement pstmt= null;
	ResultSet rs = null;
	
	DataBase database = new DataBase();
	con = database.getConnection();
	
	String query = "SELECT m_name FROM member WHERE m_idx=?";
	pstmt = con.prepareStatement(query);
	pstmt.setInt(1, Integer.parseInt(m_idx));
	rs=pstmt.executeQuery();
	if(rs.next()){
		m_name=rs.getString("m_name");
	}
	rs.close();
	pstmt.close();
	
	query = "DELETE FROM member WHERE m_idx=?";
	pstmt = con.prepareStatement(query);
	pstmt.setInt(1, Integer.parseInt(m_idx));
	pstmt.executeUpdate();
	
	pstmt.close();
	con.close();
%>
<script>
alert('<%=m_name%> 회원정보가 삭제되었습니다.');
location = "memberList.jsp";
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 삭제</title>
</head>
<body>

</body>
</html>