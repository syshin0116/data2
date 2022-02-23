<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="firstweb.DataBase"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	String m_idx      = request.getParameter("m_idx");
	String m_id       = "";
	String m_pw       = "";
	String m_name     = "";
	String m_email    = "";
	String m_phone    = "";
	Timestamp m_mdfydate = null;
	Timestamp m_rgstdate = null;

	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원정보 뷰</title>
<%
	if(m_idx == null || m_idx.equals("") || m_idx.equals("0")){
%>
<script>
alert("오류가 발생했습니다.");
location = "memberList.jsp";

</script>
<%
	}else{
		//--------- 회원정보 가져오는 코딩
		DataBase database = new DataBase();
		Connection con = null;           // database 연결을 위한 객체
		PreparedStatement pstmt  = null; // SQL 문을 서버로 보내기 위한 객체
		ResultSet rs   = null;           // SQL을 실행하고 결과를 받기 위한 객체
		String query = "SELECT * FROM member WHERE m_idx=?";
		con = database.getConnection();
		pstmt = con.prepareStatement(query);
		//--- m_idx가 문자열이기 때문에 int 값으로 형변환
		pstmt.setInt(1, Integer.parseInt(m_idx));
		rs = pstmt.executeQuery();
		
		rs.next();
		m_id = rs.getString("m_id");
		m_pw = rs.getString("m_pw");
		m_name = rs.getString("m_name");
		m_email = rs.getString("m_email");
		m_phone = rs.getString("m_phone");
		m_mdfydate = rs.getTimestamp("m_mdfydate");
		m_rgstdate = rs.getTimestamp("m_rgstdate");
		
		pstmt.close();
		rs.close();
		con.close();
		//--------- 회원정보 가져오는 코딩
	}
%>
	<style>
        table {
            width: 100%;
            border-top: 1px solid #444444;
            border-collapse: collapse;
        }
        th, td {
            border-bottom: 1px solid #444444;
            padding: 10px;
        }
    </style>
    <script>
    function userDelete(m_idx, m_name){
		if(confirm(m_name+" 회원을 정말로 삭제하시겠습니까?")){
			//location = "memberDelete.jsp?m_idx="+m_idx+"&m_name="+m_name;
			location = "memberDelete.jsp?m_idx="+m_idx;
		}
	}
    </script>
</head>
<body>
	<h2>회원정보뷰</h2>
	<table>
		<tr>
			<td>시퀀스</td>
			<td><%=m_idx%></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><%=m_name%></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><%=m_id%></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><%=m_pw%></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%=m_phone%></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><%=m_email%></td>
		</tr>
		<tr>
			<td>수정일</td>
			<%if(m_mdfydate == null){%>
		<td></td>
		<%}else{%>
		<td><%=format1.format(m_mdfydate)%></td>
		<%}%>
		</tr>
		<tr>
			<td>등록일</td>
			<td><%=m_rgstdate%></td>
		</tr>
	</table>
	<input type="button" onclick="location='memberList.jsp'" value="목록">
	<input type="button" onclick="location='memberModify.jsp?m_idx=<%=m_idx%>'" value="수정">
	<input type="button" onclick="userDelete(<%=m_idx%>, '<%=m_name%>')" value="삭제">
</body>
</html>
