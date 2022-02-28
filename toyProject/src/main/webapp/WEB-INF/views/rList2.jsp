<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
   <tr>
      <td class="left">영화이미지</td>
      <td class="left">영화제목</td>
      <td class="left">평점</td>
      <td class="left">작성자</td>
   </tr>
   <c:forEach items="${list}" var="one">
   <tr>
	   <td class="right"><img src="${one.mvImg}" width="100px" height="50px"></td>
	   <td class="right"><a href="rOne?rId=${one.rId}">${one.mvId}</a></td>
	   <td class="right">${one.rRating}</td>   
	   <td class="right">${one.mId}</td> <!-- one.getId() -->
   </tr>
   </c:forEach>
</table>