<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="java.sql.*" %>
<%@ page import="firstweb.DataBase"%>

<%
/*
 	id001, id002, id003은 데이터베이스 조회 하에 존재하는 아이디라고 가정한다.
*/

Connection con = null;
PreparedStatement pstmt  = null; // SQL 문을 서버로 보내기 위한 객체
ResultSet rs   = null; // SQL을 실행하고 결과를 받기위한 객체

DataBase database = new DataBase();
con = database.getConnection();
String m_id= request.getParameter("m_id");

String query = "SELECT m_idx FROM member WHERE m_id=?";
	pstmt = con.prepareStatement(query);
    pstmt.setString(1, m_id);
	rs=pstmt.executeQuery();
	if(rs.next()){
		out.print("true");
	}else{
        out.print("false");
    }
	rs.close();
	pstmt.close();
%>