<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListService</title>
</head>
<body>
	<h1>List</h1>
	<a href="/Ch08/user/register.do">직원등록</a>
	<h3>직원목록</h3>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>휴대폰</th>
			<th>나이</th>
			<th>기타</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.uid}</td>
				<td>${user.name}</td>
				<td>${user.hp}</td>
				<td>${user.age}</td>
				<td>
					<a href="/Ch08/user/modify.do?uid=${user.uid}">수정</a>
				 	<a href="/Ch08/user/delete.do?uid=${user.uid}">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>

