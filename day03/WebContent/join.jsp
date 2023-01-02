<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 스크립트 태그 사용으로 자바 코드 추가 -->
<%
	String check=request.getParameter("check");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>

<!-- 회원가입을 위한 get방식의 form태그 사용 -->
	<form action="joinOk.jsp" name="joinForm">
		<label>
		
			<!-- 아이디 입력받기 위한 text타입의 input태그 사용 -->
			아이디<input type="text" name="userId" placeholder="5자 이상으로 작성해주세요.">
			
			<!-- 중복검사를 위한 버튼타입의 input태그 사용 -->
			<input type="button" value="중복검사" onclick="send()">
		</label>
			<p id="result">
			
			<!-- 문자열 변수가 null이 아닐때 boolean타입으로 변환시 true면 중복 아이디, 아니면 사용가능 아이디로 아래쪽에 표시 -->
			<%
				if(check!=null){
			%>
					<%=Boolean.parseBoolean(check)?"중복된 아이디입니다.":"사용가능한 아이디입니다."%>
			<%		
				}
			%>
			</p>
			
		<!-- 유효성 검사를 위해 button타입의 input태그 사용하며, onclick시 send()함수 실행 -->
		<input type="button" value="완료" onclick="send()">
	</form>
</body>
<script>

/* 유효성 검사를 위한 함수 */
	function send(){
	
		/* form태그의 name값을 통해 참조*/
		var form=document.joinForm;
		
		/* 아이디가 없거나 5자 미만인 경우가 아닌 조건만 통과 */
		if(!form.userId.value || form.userId.value.length<5){
			alert("아이디를 확인해주세요.");
			return;
		}
		
		/* 유효성 검사 통과시 url의 쿼리스트링에 userId의 값을 같이 전달한다. */
		location.href="checkId.jsp?userId="+form.userId.value;
	}
</script>
</html>