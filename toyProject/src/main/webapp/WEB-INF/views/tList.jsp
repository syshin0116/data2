<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
   <tr>
      <td class="left">예매번호</td>
      <td class="left">영화제목</td>
      <td class="left">상영시간</td>
      <td class="left">좌석번호</td>
      <td class="left">예매 변경</td>
      <td class="left">예매 취소</td>
   </tr>
   <c:forEach items="${list}" var="one" varStatus="status">
   <tr>
      <td class="right">${one.tId}</td>
      <td class="right"><a href="mvOne?mvId=${list2[status.index].mvId}">${list2[status.index].mvTitle}</a></td>
      <td class="right">${one.tTime}:00</td>
      <td class="right">${one.tSeat}</td>       
      <td class="right"><a href="tUpdate.jsp?tId=${one.tId}"><button>변경</button></a></td>
      <td class="right"><button onclick="delTicket(${one.tId})">취소</button></td>
   </tr>
   </c:forEach>
</table>
<script>
	function delTicket(id)
	{
		if(confirm('정말로 취소하시겠습니까?'))
			{
				location="tDelete?tId="+id
			}
	}
	
</script>