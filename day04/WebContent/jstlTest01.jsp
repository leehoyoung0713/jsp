<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- taglib지시자로 라이브러리 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(변수)</title>
</head>
<body>
	<h2>JSTL TEST(변수)</h2>
	
	<!-- 프로퍼티 값을 설정하며, 영역은 page -->
	<c:set var="name" value="홍길동" scope="page"/>
	
	<!-- el문을 통해 값 표시 -->
	<h3>${name}</h3>
	
	<!-- out태그를 통해 값 표시-->
	<h3><c:out value="${name}"/></h3>
	
	<!-- 쿼팅으로 값표시가 아닌 리터럴 문자 표시 -->
	<h4>\${name}</h4>
	
	<!-- $기호를 통해 el문 표시 -->
	<h4>&dollar;{name}</h4>
	
	<!-- 프로퍼티 값을 설정하며, 영역은 session -->
	<c:set var="nation" value="미국" scope="session"/>
	
	<!-- session영역에 있는 nation변수를 제거 -->
	<c:remove var="nation" scope="session"/>
	
	<!-- 값이 없을 경우 '한국'이라는 값을 표시 -->
	<h4><c:out value="${nation}" default="한국"/></h4>
	
	<!-- el문을 통해 연산된 결과값 표시 -->
	<h4>${10+20}</h4>
</body>
</html>