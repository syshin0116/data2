<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="firstweb.DataBase"%>

		 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<style>
	table{
	width: 100%;
	border-top: 1px solid #444444;
	border-collapse: collapse;
	}
	th,td{
	border-bottom: 1px solid #444444;
	padding: 10px;
	}
</style>
<script>
function search(){
	var frm = document.form;
	/* if(frm.searchValue.value == ''){
		alert('검색어를 입력해주세요.');
		return;
	} */
	frm.submit();
}
function insert(){
	location = "member.html";
}
</script>
<body>
	<h2>JDBC 드라이버 테스트</h2>
	<% 
Connection con = null;
PreparedStatement pstmt  = null; // SQL 문을 서버로 보내기 위한 객체
ResultSet rs   = null; // SQL을 실행하고 결과를 받기위한 객체
/* String connurl = "jdbc:postgres://localhost:3306/mars"; */ 
/* String connurl = "jdbc:mariadb://localhost:3306/mars";
String user = "mars";
String pw = "p@ssword"; */

String query  = "SELECT * FROM member";
String searchValue = "";

if (request.getParameter("searchValue") != null){
	searchValue = request.getParameter("searchValue");
}
try{
	/* Class.forName("org.mariadb.jdbc.Driver"); 
	/* Class.forName("org.postgresql.Driver"); */
	/* out.println("Mariadb 드라이버 로딩");
	
	con = DriverManager.getConnection(connurl, user,pw);
	out.println("Mariadb Connection 연결 성공~"); */
	DataBase database = new DataBase();
	con = database.getConnection();
	
	if(request.getParameter("searchValue") != null){
		query= "SELECT m_idx, m_name, m_id, m_pw, m_email, m_phone, m_mdfydate, m_rgstdate"
				+" FROM member WHERE m_name LIKE ?";
	}
	pstmt = con.prepareStatement(query);
	if(request.getParameter("searchValue") != null){
		pstmt.setString(1, "%"+request.getParameter("searchValue")+"%");
	}
	rs = pstmt.executeQuery();
	
%>
<form action="memberList.jsp" name="form">
	<input type="text" name="searchValue" value="<%=searchValue%>">
	<input type="button" onclick="search()" value="검색">
	<input type="button" onclick="insert()" value="회원가입">
</form>
<table>
	<tr>
		<td>시퀀스</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>휴대폰번호</td>
		<td>수정일</td>
		<td>등록일</td>
	</tr>
	<%
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	while(rs.next()) {
		String m_idx = rs.getString("m_idx");
		String m_id = rs.getString("m_id");
		String m_pw = rs.getString("m_pw");
		String m_name = rs.getString("m_name");
		String m_email = rs.getString("m_email");
		String m_phone = rs.getString("m_phone");
		Timestamp m_mdfydate = rs.getTimestamp("m_mdfydate");
		Timestamp m_rgstdate = rs.getTimestamp("m_rgstdate");
	%>
	<tr>
		<td><%=m_idx%></td>
		<td><%=m_id%></td>
		<td><%=m_pw%></td>
		<td><a href="memberView.jsp?m_idx=<%=m_idx%>"><%=m_name%></td>
		<td><%=m_email%></td>
		<td><%=m_phone%></td>
		<%if(m_mdfydate == null){%>
		<td></td>
		<%}else{%>
		<td><%=format1.format(m_mdfydate)%></td>
		<%}%>
		<td><%=format1.format(m_rgstdate)%></td>
	</tr>
	<%
	}
	/* }catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace(); */
	}
	finally {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		if(rs != null) {
			try {
				rs.close();
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
</table>
</body>
</html>