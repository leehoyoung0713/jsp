<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 자바빈 객체를 생성하는 액션태그 -->
<jsp:useBean id="userDAO" class="dao.UserDAO"/>

<!-- 파라미터로 넘겨받은 값을 mybatis와 매핑된 메서드의 매개변수로 넣어주고, 쿼리스트링으로 리다이렉트 주소에 결과값을 붙여서 전달 -->
<%
	String userId = request.getParameter("userId");
	response.sendRedirect("join.jsp?check=" + userDAO.checkId(userId));
%>