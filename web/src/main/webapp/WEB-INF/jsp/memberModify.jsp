<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" type="text/css" href=${contextPath}/css/style.css>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script>
$(function(){
	$("#btn_update").click(function(){
			if($("#m_name").val()==''){
				alert("이름을 입력해주세요.");
				$("#m_name").focus();
				return;
			}if($("#m_email").val()==''){
				alert("이메일을 입력해주세요.");
				$("#m_email").focus();
				return;
			}if($("#m_phone").val()==''){
				alert("이름을 입력해주세요.");
				$("#m_phone").focus();
				return;
			}if($("#m_pw").val() != $ ("#m_pwconfirm").val() ){
				alert("비밀번호와 비밀번호 확인이 같지 않습니다");
				return;
			}else{
				if(confirm("수정하시겠습니까?")){
				$('#frmMember').submit();
				}
			}
	});
});
</script>
</head>
<body>
	<div class="container">
	<div class="section">
	<h2>회원정보 수정 <button style="float:right" onclick="location='logout'" class = "btn_style_submit">로그아웃</button></h2>
	<form action="${contextPath}/memberUpdate" method="get" id="frmMember">
		<input type="hidden" name="m_idx" id = "m_idx" value="${member_view.m_idx}"/>
	<table class="bluetop">
		<tr>
			<th>시퀀스</th>
			<td>${member_view.m_idx}</td>
			<td>${member_view.m_idx}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member_view.m_name}</td>
			<td><input type="text" name="m_name" id="m_name"></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${member_view.m_id}</td>
			<td>${member_view.m_id}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${member_view.m_pw}</td>
			<td><input type="password" name="m_pw" id="m_pw"></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td>${member_view.m_pw}</td>
			<td><input type="password" name="m_pwconfirm" id="m_pwconfirm"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${member_view.m_email}</td>
			<td><input type="text" name="m_email" id="m_email"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${member_view.m_phone}</td>
			<td><input type="text" name="m_phone" id="m_phone"></td>
		</tr>
		<tr>
			<th>수정일</th>
			<td><fmt:formatDate value="${member_view.m_mdfydate}" pattern="yyyy.MM.dd hh:mm"/></td>
			<td><fmt:formatDate value="${member_view.m_mdfydate}" pattern="yyyy.MM.dd hh:mm"/></td>
		</tr>
		<tr>
			<th>등록일</th>
			<td><fmt:formatDate value="${member_view.m_rgstdate}" pattern="yyyy.MM.dd hh:mm"/></td>
			<td><fmt:formatDate value="${member_view.m_rgstdate}" pattern="yyyy.MM.dd hh:mm"/></td>
		</tr>
	</table>
	
	<div class="btns"><button type = "button" class = "btn_style_submit" id="btn_update">수정</button></div>
	<div class="btns"><button type = "button" onclick="location='${contextPath}/memberList'" class = "btn_style_submit">회원 목록</button></div>
	<button type = "button" onclick="location='${contextPath}/memberView?m_idx=${member_view.m_idx}'" class = "btn_style_submit" style="float:left">취소</button>
	</form>
	</div>
	</div>
	

</body>
</html>