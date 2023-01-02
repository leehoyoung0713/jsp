<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax 테스트 - GET</title>
</head>
<body>

<!-- 결과값 표시를 위한 제목 태그 -->
	<h1 id="result"></h1>
	
	<!-- button태그의 클릭이벤트시 send()메서드 실행 -->
	<button onclick="send()">데이터 가져오기</button>
</body>
<script>

/* ajax요청을 처리하기 위한 함수 */
	function send(){
	
	/* 서버로부터 XML 데이터를 전송받아 처리하는 데 사용 */
		var xhr = new XMLHttpRequest();
		//xhr.open("GET", "data.jsp");
		
		/* ajax 요청을 초기화하면서 post방식, url은 data.jsp, 동기식으로 설정 */
		xhr.open("POST", "data.jsp");
		
		/* HTTP요청 헤더의 값을 설정 */
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		/* 작성된 ajax요청을 서버로 전달하는 메서드 */
		xhr.send("msg1=반갑습니다&msg2=어서오세요");
		
		/* XMLHttpRequest 객체의 readyState 프로퍼티 값이 변할 때마다 자동으로 호출되는 함수를 설정 */
		xhr.onreadystatechange = function(){
			
			/* xhr.readyState값이 XMLHttpRequest.DONE 이면서 상태코드가 200인 경우*/
			if(xhr.readyState == XMLHttpRequest.DONE && xhr.status == 200){
				
				/* id속성이 result인 텍스트에 응답받은 텍스트를 삽입 */
				document.getElementById("result").innerHTML = xhr.responseText;
			}
		}
	}
</script>
</html>
















