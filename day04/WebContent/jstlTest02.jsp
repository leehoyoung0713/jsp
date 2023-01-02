<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- taglib지시자로 라이브러리 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(출력의 종류)</title>
</head>
<body>

<!-- 쿼팅 및 script구문 사용으로 값 표시 -->
	<c:out value="${\" <script>alert('안녕');</script>\"}"/>
</body>
</html>