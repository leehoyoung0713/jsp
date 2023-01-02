<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 자바 빈 객체 생성을 위한 태그 -->
<jsp:useBean id="userDAO" class="dao.UserDAO"/>
<jsp:useBean id="userVO" class="vo.UserVO"/>
    <!-- 전달받은 데이터를 DB에 INSERT하기 -->

<!-- 스크립트 태그를 사용하여 자바 코드 추가, 파라미터로 전달받은 값을 mybatis와 매핑된 메서드의 매개변수로 전달, db저장 후 redirect페이지 설정 -->
<%
	userVO.setUserName(request.getParameter("userId"));
	userDAO.insert(userVO);
	response.sendRedirect("login.jsp");
%>