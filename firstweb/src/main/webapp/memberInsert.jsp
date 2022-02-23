<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="firstweb.DataBase"%>

<% 
request.setCharacterEncoding("utf-8");
String m_id= request.getParameter("m_id");
String m_pw= request.getParameter("m_pw");
String m_name= request.getParameter("m_name");
String m_email= request.getParameter("m_email");
String m_phone= request.getParameter("m_phone");

Connection con = null;
PreparedStatement pstmt= null;

/* String connurl = "jdbc:mariadb://localhost:3306/mars";
String user = "mars";
String pw = "p@ssword"; */
String query="";
try{
	/* Class.forName("org.mariadb.jdbc.Driver"); 
	/* Class.forName("org.postgresql.Driver"); */
	/* out.println("Mariadb 드라이버 로딩");
	
	con = DriverManager.getConnection(connurl, user,pw);
	out.println("Mariadb Connection 연결 성공~"); */ 
	
	DataBase database = new DataBase();
	con = database.getConnection();
	
	query = "INSERT INTO member (m_id, m_pw, m_name, m_email, m_phone) VALUES (?,?,?,?,?)";
	pstmt = con.prepareStatement(query);
	pstmt.setString(1, m_id);
	pstmt.setString(2, m_pw);
	pstmt.setString(3, m_name);
	pstmt.setString(4, m_email);
	pstmt.setString(5, m_phone);
	
	pstmt.executeUpdate();
	
	/* }catch(Exception e){
    	e.printStackTrace(); */
	}finally{
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
%>
<script>
alert('회원가입되었습니다.');
location = "memberList.jsp";
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

</body>
</html>