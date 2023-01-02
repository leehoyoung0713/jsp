<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 스크립트 태그를 사용하여 자바 코드를 추가 -->
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<!-- 파라미터로 넘겨받은 값을 붙여서 body태그 내에 표시 -->
	<%=request.getParameter("msg1") %>안녕하세요<%=request.getParameter("msg2") %>
</body>
</html>