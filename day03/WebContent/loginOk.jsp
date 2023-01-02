<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 자바빈 객체를 생성하는 액션태그 -->
<jsp:useBean id="userDAO" class="dao.UserDAO"/>

<!-- 스크립트 태그 사용으로 자바 코드 추가 -->
<%
	response.sendRedirect(userDAO.checkId(request.getParameter("userId"))?"index.jsp":"login.jsp?check=false");        
%>