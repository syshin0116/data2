<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
tr {
	text-align: right;
}

td {
	width: 30;
}

table {
	width: 50%;
	hegiht: 100%;
	border: 5px solid black;
	border-spacing: 10px;
	border-collapse: separate;
	table-layout: fixed;
}
</style>
<table>
	<pre>		  	SCREEN</pre>
	<tr>
		<c:forEach items="${seats}" var="one" varStatus="status">
			<c:if test="${one > 0}">
				<td style="background-color: gray;">${one}</td>
			</c:if>
			<c:if test="${one eq 0}">
				<td><a
					href='tUpdate?tId=${tId}&mId=${mId}&mvId=${mvId}&tTime=${time}&tSeat=${status.count}'><button>${status.count}</button></a></td>
			</c:if>
			<c:if test="${status.count mod 4 eq 0}">
				</tr><tr>
			</c:if>
		</c:forEach>
	</tr>
</table>

