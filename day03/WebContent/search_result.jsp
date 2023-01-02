<!-- 스크립트 태그에서 객체 및 클래스를 사용하기 위한 지시자 사용-->
<%@ page import="vo.GuestVO" %>
<%@ page import="dao.GuestDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 스크립트 태그 사용으로 자바 코드 추가(dao 클래스의 메서드를 통해 db조회 결과값을 가져오기 위해) -->
<%
	request.setCharacterEncoding("UTF-8");
	GuestDAO guestDAO=new GuestDAO();
	ArrayList<GuestVO> guests=guestDAO.selectAll();
%>
	<main>
	
	<!-- 이름을 입력받고 값을 전달하기 위해 get방식을 통한 form태그 사용 -->
		<form action="guest" method="get">
		
			<!-- 이름을 입력받기 위한 text타입의 input태그 -->
			이름<input type="text" placeholder="이름을 입력하세요." name="name">
			
			<!-- 결과 전송을 위해 submit타입의 button태그 사용 -->
			<button>결과 조회</button>
		</form>
	</main>
</body>
</html>