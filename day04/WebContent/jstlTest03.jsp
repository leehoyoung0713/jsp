<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<!-- taglib지시자로 라이브러리 선언 -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(제어문-조건식)</title>
</head>
<body>

<!-- 값이 admin인 id변수 선언 -->
	<c:set var="id" value="admin"/>
	
	<!-- 조건문을 통해 'admin'인 경우 id변수값 출력 -->
	<c:if test="${id eq 'admin' }">
		<h3>현재 로그인된 계정은 <c:out value="${id}"/></h3>
	</c:if>
	
		<!-- 조건문을 통해 'member'인 경우 id변수값 출력 -->
	<c:if test="${id eq 'member'}">
		<h3>현재 로그인된 계정은 일반 계정입니다.<c:out value="${id}"/></h3>
	</c:if>
	
	<!-- jstl태그를 사용하여 조건에 따라 분기하는 choose 태그 사용 -->
	<c:choose>
	
		<!-- 조건문을 통해 'admin'인 경우 id변수값 출력 -->
		<c:when test="${id eq 'admin'}">
			<h3>현재 로그인된 계정은 <c:out value="${ id}"/></h3>
		</c:when>
		
		<!-- 나머지의 경우 -->
		<c:otherwise>
			<h3>현재 로그인된 계정은 일반 계정입니다.</h3>
		</c:otherwise>
	</c:choose>
	
</body>
</html>