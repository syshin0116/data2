<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 뷰</title>
<link rel="stylesheet" type="text/css" href=${contextPath}/css/style.css>
<script>
	function member_del(value, idx){
		if(confirm(value+"님을 삭제하시겠습니까?")){
			location.href ="${contextPath}/memberDelete?m_idx="+idx;
		}
	}
</script>
</head>
<body>
	<div class="container">
	<div class="section">
	<h2>회원정보 뷰 (${sessionScope.user_name}님 환영합니다.)
	<button style="float:right" onclick="location='logout'" class = "btn_style_submit">로그아웃</button>
	</h2>
	<table class="bluetop">
		<tr>
			<th>시퀀스</th>
			<td>${member_view.m_idx}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member_view.m_name}</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${member_view.m_id}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${member_view.m_email}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${member_view.m_phone}</td>
		</tr>
		<tr>
			<th>사진</th>
			<td>${member_view.m_file}</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td><fmt:formatDate value="${member_view.m_mdfydate}" pattern="yyyy.MM.dd hh:mm"/></td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><fmt:formatDate value="${member_view.m_rgstdate}" pattern="yyyy.MM.dd hh:mm"/></td>
		</tr>
	</table>
	<button onclick="location='${contextPath}/memberList'" class = "btn_style_submit">회원 목록</button>
	<div class="btns"><button onclick="location='${contextPath}/memberModify?m_idx=${member_view.m_idx}'" class = "btn_style_submit">회원 수정</button></div>
	<div class="btns"><button onclick="member_del('${member_view.m_name}',${member_view.m_idx})" class = "btn_style_submit">회원 삭제</button></div>
	</div>
	</div>
	

</body>
</html>