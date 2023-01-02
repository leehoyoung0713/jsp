<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>

<!-- post방식의 form태그 사용하며 joinOk.jsp페이지로 name에 해당하는 값들 포함하여 전달 -->
	<form action="joinOk.jsp" name="joinForm" method="post">
		<label>
		
		<!-- text타입의 input태그 사용 -->
			아이디 <input type="text" name="userId" placeholder="5자 이상으로 작성해주세요.">
			
			<!-- button타입의 input태그 사용(유효성 검사를 위해 onclick 이벤트의 send()함수 실행) -->
			<input type="button" value="중복검사" onclick="send()">
		</label>
		
		<!-- 유효성 검사의 값을 통해 텍스트를 표시하기 위한 태그 사용 -->
		<p id="result">
		</p>
		
		<!-- submit타입의 input태그 사용 -->
		<input type="submit" value="완료">
	</form>
</body>

<!-- jquery사용을 위해 분산된 여러 서버 중 하나의 서버에서 javascript 파일 포함 -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>

/* flag변수 선언 및 초기화 */
	let check = true;

/* name이 userId인 input태그의 커서가 올라갔을때 */
	$("input[name='userId']").on("focus", function(){
		check = true;
	});
	
	/* type이 submit인 input태그의 커서를 클릭했을때 */
	$("input[type='submit']").on("click", function(e){
		
		/* 기본 기능인 submit을 제거하기 위한 설정 */
		e.preventDefault();
		
		/* flag변수가 true일때 */
		if(check){
			alert("아이디 중복검사를 진행해주세요.");
			return;
		}
		
		/* form태그에서 설정해놓은 action에 해당하는 url로 이동 */
		joinForm.submit();
	});

	/* 중복검사를 위한 함수 */
	function send(){
		
		/* name이 userId인 input태그의 값을 저장 */
		var $value = $("input[name='userId']").val();
		
		/* 값이 없거나, 5자 이하이면 */
		if(!$value || $value.length < 5){
			alert("아이디를 확인해주세요.");
			return;
		}
		
		/* 비동기 요청을 위한 ajax */
		$.ajax({
			
			/* 경로 */
			url: "checkId_ajax.jsp",
			
			/* get방식 */
			type: "get",
			
			/* 쿼리스트링으로 입력받은 값 전달 */
			data: "userId=" + $value,
			
			/* 전송시 form방식의 타입을 설정 */
			contentType: "application/x-www-form-urlencoded",
			
			/* 전송 후 응답받는 타입 지정 */
			dataType: "text",
			
			/* 성공시 */
			success: function(result){
				
				/* 결과를 공백을 제거하고 정렬하여 저장  */
				result = result.trim();
				
				/* json object타입의 객체 값으로 변환후 조건비교 */
				if(JSON.parse(result)){
					
					/* p태그의 id속성이 result인 태그의 텍스트 값을 추가 */
					$("p#result").text("중복된 아이디입니다.");
					check = true;
				}else{
					
					/* p태그의 id속성이 result인 태그의 텍스트 값을 추가 */
					$("p#result").text("사용가능한 아이디입니다.");
					check = false;
				}
			},
			
			/* 에러시 출력되는 함수 */
			error: function(xhr, status, error){
				console.log(error);
			}
		});
		
	}
</script>
</html>













