<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>2_5_Include</title>
	<!-- 
		날짜 : 2021-05-31
		이름 : 박재형
		내용 : JSP Include 지시자 실습하기
		
		include 지시자
			- 공통의 전역파일을 삽입하는 지시자
			- 일반적으로 UI 모듈, 공통전역 파일 변수를 삽입할 때 사용
			- 정적타임 삽입, 참고) include 태그는 동적타임에 삽입 
	-->
</head>
<body>
	<h3>4.JSP 인클루드 실습하기</h3>
	<!--@ : 지시자  -->
	<%@ include file="./inc/_header.jsp" %>
	<main>
		<h1>메인영역</h1>
	</main>
	<%@ include file="./inc/_footer.jsp" %>
</body>
</html>