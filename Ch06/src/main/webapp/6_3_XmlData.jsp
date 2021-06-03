<%@ page contentType="text/xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	/* 
		날짜 : 2021-06-03
		이름 : 박재형
		내용 : XML 실습하기
		
		* XML(Extensible Markup Language)
			- Json과 더불어 이기종간의 데이터 존송을 위한 문서 포멧.
			- 사용자가 직접 태그를 정의한다.
			- Json보다 파싱, 전송 속도가 느리다는 단점이 있다 --> 잘안씀
		
	*/
	
	String xml = "<members>";	
		  xml += "<member>";
		  xml += "<uid>a101</uid>";
		  xml += "<name>홍길동</name>";
		  xml += "<hp>010-1234-4567</hp>";
		  xml += "<pos>사원</pos>";
		  xml += "<dep>101</dep>";
		  xml += "<rdate>2021-06-03 10:40:12</rdate>";
		  xml += "</member>";
		  xml += "<member>";
		  xml += "<uid>a102</uid>";
		  xml += "<name>강감찬</name>";
		  xml += "<hp>010-4654-1111</hp>";
		  xml += "<pos>부장</pos>";
		  xml += "<dep>102</dep>";
		  xml += "<rdate>2021-06-03 15:49:12</rdate>";
		  xml += "</member>";
		  xml += "</members>";
		  
		  out.print(xml);
	
%>