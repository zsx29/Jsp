<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<!-- 
	날짜 : 2021-06-28
	내용 : JSTL(Java Standard Tag Library)
 -->
	<h3>4.JSTL(Java Standard Tag Library)</h3>
	<h4>스크립트릿</h4>
	<%
		String str = "hello";
		out.print("<p>" + str +"</p>");
		
		int num1 = 1;
		int num2 = 2;
		int num3 = 3;
		
		if(num1 < num2){
			out.print("<p>num1 은 num2보다 크다.</p>");
		}else{
			out.print("<p>num1 은 num2보다 크다.</p>");
		}
		
		if(num1 > num2){
			out.print("<p>num1 은 num2보다 크다.</p>");
		}else if(num2 > num3){
			out.print("<p>num2 은 num3보다 크다.</p>");
		}else{
			out.print("<p>num3이 가장크다.</p>");
		}
		
		for(int i = 1; i <= 5; i++){
			out.print("<p>"+i+".hello JSTL</p>");
		}
		
		String people[] = {"김유신", "장보고", "김춘추", "홍길동"};
		
		for(String person : people){
			out.print("<p>"+person+"</p>");
		}
		
		int sum = 0;
		for(int k = 1; k <= 10; k++){
			sum += k;
		}
		
		out.print("<p>" +sum+ "</p>");
		
		// 문자열 처리
		String hello = "hello korea";
		
		out.print("<p>문자열 길이"+hello.length()+"</p>");
		out.print("<p>문자열 자르기"+hello.substring(6, 10)+"</p>");
		out.print("<p>문자열 교체"+hello.replace("korea", "busan")+"</p>");
		out.print("<p>문자열 인덱스번호"+hello.indexOf("e")+"</p>");
	%>
	<h4>JSTL</h4>
	
	<!-- 변수 선언 -->
	<c:set var="str" value="hello"/>
	<p>str : ${str}</p>
	
	<c:set var="num1" value="1"/>
	<p>num1 : ${num1}
	<c:set var="num2" value="2"/>
	
	<c:set var="num3" value="3"/>
	
	<!-- 조건문 -->
	
	<c:if test="${num1 lt num2}">
		<p>num1은 num2보다 작다.</p>
	</c:if>
	
	<c:choose>
		<c:when test="${num1 gt num2}">
			<p>num1 은 num2 보다 크다.</p>
		</c:when>
		<c:otherwise>
			<p>num1 은 num2 보다 작다.</p>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${num1 gt num2}">
			<p>num1 은 num2 보다 크다.</p>
		</c:when>
		<c:when test="${num2 gt num3}">
			<p>num2 은 num3 보다 크다.</p>
		</c:when>
		<c:otherwise>
			<p>num3이 가장크다.</p>
		</c:otherwise>
	</c:choose>
	
	<!-- 반복문 -->
	<c:forEach var="i" begin="1" end="5">
		<p>${i}.Hello JSTL!</p>
	</c:forEach>
	
	<c:set var="people">김유신,김춘추,장보고,강감찬,이순신</c:set>
	<c:forEach var="person" items="${people}">
		<p>${person}</p>
	</c:forEach>
	
	<c:set var="sum" value="0"/>
	<c:forEach var="k" begin="1" end="10">
		<c:set var="sum" value="${sum + k}"/>
	</c:forEach>
	
	<p>1부터 10까지 합 : ${sum}</p>
	<!-- 문자열처리-->

	<c:set var="hello" value="hello korea"></c:set>
	<p>문자열 길이 : ${f:length(hello)}</p> 
	<p>문자열 길이 : ${f:substring(hello, 6 ,10)}</p> 
	<p>문자열 길이 : ${f:replace(hello, "korea", "busan")}</p> 
	<p>문자열 길이 : ${f:indexOf(hello, "e")}</p> 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>






















































