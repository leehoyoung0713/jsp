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

	<!-- 반복문을 통해 i라는 변수의 값을 1부터 10까지 1씩 증가하며 출력 -->
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}"/>
	</c:forEach>
</body>
</html>