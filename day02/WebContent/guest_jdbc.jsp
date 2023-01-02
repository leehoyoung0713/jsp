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

<!-- <form action="guest" method="post">
	이름<input type="text" name="name" placeholder="이름 입력">
	<button>결과조회</button>
</form> -->

<!-- 스크립트 태그를 사용하여 자바 코드를 추가(dao 클래스의 메서드를 통해 db조회 결과값을 가져오기 위해) -->
<%
	request.setCharacterEncoding("UTF-8");
	GuestDAO guestDAO=new GuestDAO();
	ArrayList<GuestVO> guests=guestDAO.selectArrange(true);
%>
<main>

<!-- 이름을 입력받고 값을 전달하기 위해 get방식을 통한 form태그 사용 -->
	<form action="guest_jdbc_desc.jsp" method="get">
	
		<!-- 이름을 입력받기 위한 text타입의 input태그 -->
		<input type="text" name="keyword" placeholder="이름 입력">
		
				<!-- 클릭시 내림차순 정렬 -->
		<p><a href="javascript:send(false)">정렬↓</a></p>
	</form>
</main>

<!-- 조회된 결과값을 표시하기 위해 스크립트 태그 사용으로 자바의 반복문 코드를 추가 -->
<table border="1">
	<%for(int i=0;i<guests.size();i++){ %>
		<tr>
			<td><%=guests.get(i).getGuestNumber() %></td>
			<td><%=guests.get(i).getGuestName() %></td>
			<td><%=guests.get(i).getGuestBirth() %></td>
		</tr>
	<%} %>
</table>
</body>

<!-- 정렬을 위한 order.js 자바스크립트 파일 추가 -->
<script src="order.js"></script>
</html>