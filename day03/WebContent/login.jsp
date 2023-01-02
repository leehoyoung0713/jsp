<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 스크립트 태그 사용으로 자바 코드 추가 -->
<%
	String check = request.getParameter("check");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<!-- 로그인 페이지 구현 -->
<!-- 아이디만 입력받아서 검사 -->
	<section>
	
	<!-- type이 hidden인 input태그 사용, 값은 파라미터로 전달받은 값-->
		<input type="hidden" value=<%=check%> name="check">
		
		<!-- post방식의 form태그 사용하며 action속성을 사용하여 loginOk.jsp페이지로 이동 -->
		<form action="loginOk.jsp" method="post">
			<label>
			
			<!-- 타입이 text인 input태그 사용 -->
				아이디 <input type="text" name="userId">
			</label>
			<button>로그인</button>
		</form>
	</section>
</body>

<!-- jquery사용을 위해 분산된 여러 서버 중 하나의 서버에서 javascript 파일 포함 -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>

/* name이 check인 input태그의 값을 저장 */
	var check = $("input[name='check']").val();
	
	/* check값이 null문자열, null값이 아닌경우 */
	if(check != "null" && check != null){
		alert("아이디 또는 비밀번호를 다시 확인해주세요.");
	}
</script>
</html>












