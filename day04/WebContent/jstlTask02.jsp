<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- taglib지시자로 라이브러리 선언 -->
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 두번째 실습</title>
</head>
<body>
	<!-- 1단부터 100단까지 중 사용자에게 입력받은 단수로 구구단 출력하기
	입력받은 값이 정수인지 아닌지 판단, 값을 입력했는지 안했는지 판단.
	다른 페이지 이동 없이 현재 페이지에서만 기능 구현
	자바스크립트 사용가능
	구구단 출력은 JSTL로 구현
	입력은 form태그로 입력받는다. -->
	
	<!-- jstl태그를 사용하여 조건에 따라 분기하는 choose 태그 사용 -->
	<c:choose>
	
	<!-- 파라미터의 결과값이 비어있을때 -->
		<c:when test="${empty param.dan}">
		
		<!-- 타입이 button인 button태그 표시,유효성 검사를 위해 onclick이벤트시 send()메서드 실행-->
			<form name="gugudan">
				이름<input type="text" placeholder="단 입력" name="dan">
				<button type="button" onclick="send()">입력</button>
			</form>
		</c:when>
		
		<!-- 파라미터의 결과값이 1이상이면서 100이하일때 -->
		<c:when test="${param.dan>0 and param.dan<101 }">
		
		<!-- 반복문을 통해 단에 해당하는 구구단의 과정 및 결과값 표시 -->
			<c:forEach var="i" begin="1" end="9">
				<c:out value="${param.dan}*${i}=${param.dan*i}"/><br>
			</c:forEach>
		</c:when>
		
		<!-- 나머지의 경우 -->
		<c:otherwise>
			<h3>1~100단 까지만 입력 가능</h3>
		</c:otherwise>
	</c:choose>
</body>

<!-- jquery사용을 위해 분산된 여러 서버 중 하나의 서버에서 javascript 파일 포함 -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>

/* name속성이 dan인 input태그의 키가 눌렸을때 */
	$("input[name='dan']").keypress(function(e){
		
		/* 키값이 enter인 경우 */
		if(e.keyCode==13){
			
			/* send()메서드 호출 */
			send();
			
			/* 기본 속성 제거를 위한 설정 */
			e.preventDefault();
		}
	});

/* 유효성 검사를 위한 함수 */
	function send(){
	/* name이 dan인 input태그의 값을 저장 */
		var value=$("input[name='dan']").val();
	
	/* 정수인지 판별 */
		var check=value%1==0;
		
	
	/* 값이 없거나, 소수인경우 */
		if(!check || !value){
			alert('다시 입력하세요.');
			return;
		}
	
		/* name이 dan인 input태그의 값을 정수로 변환하여 저장 */
		$("input[name='dan']").val(parseInt(value));
		
		/* 정수 값을 전달 */
		gugudan.submit();
	}

</script>
</html>