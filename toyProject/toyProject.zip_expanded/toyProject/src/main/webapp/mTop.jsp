<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
		if (session.getAttribute("mId") == null) {
	%>
	<form action="login">
		<table>
			<tr>
				<td colspan="2">
					<button style="width: 200px; height: 50px;" class="btn btn-success"
						type="submit">로그인</button>
				</td>

			</tr>
		</table>
	</form>
	<a href="mRegister">
		<button style="width: 200px; height: 50px;" class="btn btn-danger"
			type="submit">회원가입</button>
	</a>
	<hr>
	<%
		} else {
	%>
	<div class="infoBox">
		<div class="pwChange">
			<a>${mId}님 환영합니다.</a> <a href="mMyInfo?mId=${mId}" target="parent"
				class="link_my" data-clk="mModify">"마이 페이지"</a>
		</div>
		<button type="button" class="btn" id="outBtn" onclick="location.href='logout'">
			<span>로그아웃</span>
		</button>
	</div>
	<%
		}
	%>