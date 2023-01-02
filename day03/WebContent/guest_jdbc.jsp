<!-- 스크립트 태그에서 객체 및 클래스를 사용하기 위한 지시자 사용-->
<%@page import="vo.GuestVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.GuestDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전체 목록</title>
<style>
	p {
	    margin-left: 120px;
	}
</style>
</head>
<body>
<!-- 스크립트 태그 사용으로 자바 코드 추가, 매핑된 mybatis메서드를 통해 결과값들을 ArrayList<GuestVO>타입의 객체에 저장-->
	<%
		request.setCharacterEncoding("UTF-8");
		GuestDAO guestDAO = new GuestDAO();
		ArrayList<GuestVO> guests = guestDAO.selectArrange(true);
	%>
	<main>
	<!-- 이름을 입력받고 값을 전달하기 위해 get방식을 통한 form태그 사용 -->
		<form action="search_result.jsp" method="get">
		
		<!-- 이름을 입력받기 위한 text타입의 input태그 -->
			<input type="text" placeholder="이름을 입력하세요." name="keyword">
		</form>
		
		<!-- 클릭시 내림차순 정렬 -->
		<p><a href="javascript:send(false);">정렬 ↓</a></p>
	</main>
	
	<!-- 조회된 결과값을 표시하기 위해 스크립트 태그 사용으로 자바의 반복문 코드를 추가 -->
	<table border="1">
		<%for(int i=0; i<guests.size(); i++){ %>
			<tr>
				<td><%=guests.get(i).getGuestNumber()%></td>
				<td><%=guests.get(i).getGuestName()%></td>
				<td><%=guests.get(i).getGuestBirth()%></td>
			</tr>
		<%} %>
	</table>
</body>

<!-- 정렬을 위한 order.js 자바스크립트 파일 추가 -->
<script src="order.js"></script>
</html>
















