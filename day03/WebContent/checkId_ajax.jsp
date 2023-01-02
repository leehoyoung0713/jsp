<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 자바빈 객체를 생성하는 액션태그 -->
<jsp:useBean id="userDAO" class="dao.UserDAO"/>

<!-- 스크립트 태그 사용으로 자바 코드를 추가하며, 파라미터로 넘겨받은 값을 mybatis와 매핑된 메서드의 매개변수로 넘겨주며 출력 스트림에 결과값을 작성 -->
<%
	out.print(userDAO.checkId(request.getParameter("userId")));
%>