<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <table>
   <tr>
      <td class="left">아이디</td>
      <td class="left">비밀번호</td>
      <td class="left">이메일</td>
      <td class="left">전화번호</td>
   </tr>
   <tr>
      <td class="right">${one.mId}</td> <!-- one.getId() -->
      <td class="right">${one.mPw}</td>    
      <td class="right">${one.mEmail}</td>     
      <td class="right">${one.mPhone}</td>
   </tr>
</table>
<a href = "mModify?mId=${one.mId}">
<button class="btn btn-success">회원정보 수정</button>
</a>
<a href = "mDelete?mId=${one.mId}">
<button class="btn btn-danger">회원정보 삭제</button>
</a>

