package com.koreait.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Oper
 */
/* @WebServlet("/oper") */
//사용자의 요청을 처리하기 위한 HttpServlet 클래스 상속
public class Oper extends HttpServlet {
	
//	직렬화를 통해 유효한 파일인지 확인하기 위한 설정(필수)
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//  Post요청이 들어왔을때 처리하기 위한 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		요청한 client에 내용을 전달할때 사용하는 타입 설정
		response.setContentType("text/html; charset=UTF-8");
		
//		getParameter메서드를 통해 키값에 해당하는 "input"의 value값을 input변수에 저장
		String input =request.getParameter("input");
		
//		Servlet으로 들어온 요청을 텍스트 형태로 응답하기 위해 출력스트림을 얻어야 하므로 getWriter()메서드 사용[바이트를 문자 형태를 가지는 객체로 바꿔준다]
		PrintWriter out=response.getWriter();
		
//		사칙연산에 필요한 연산자, 변수 선언 및 초기화
		String opers="+-*/";
		String oper=null;
		String[] nums=null;
		Calc calc=null;
		int result=0;
		String msg=null;
		
//		반복문을 순회하면서 연산자 기호를 추출
		for(int i=0;i<input.length();i++) {
			for(int j=0;j<opers.length();j++) {
				if(input.charAt(i)==opers.charAt(j)) {
					oper=String.valueOf(input.charAt(i));
				}
			}
		}
		
//		문자열 배열에 연산자를 기준으로 나눠서 문자열 입력값 2개를 저장
		nums=input.split("\\"+oper);
		
//		String 타입의 매개변수가 2개인 생성자 호출
		calc=new Calc(nums[0],nums[1]);
		
//		사칙 연산의 결과로 연산에 예외가 발생할 수 있으므로 try-catch구문을 사용
		try {
			calc=new Calc(nums[0],nums[1]);
			
//			2개 이상의 입력값을 입력할 경우 NumberFormatException예외 발생
			if(nums.length>2) {throw new NumberFormatException();}
			
			switch(oper) {
//			'+'기호인 경우
			case	"+":
//				Calc클래스의 add메서드 호출
				calc.add();
				break;
				
//			'-'기호인 경우
			case	"-":
//				Calc클래스의 sub메서드 호출
				calc.sub();
				break;
				
//			'*'기호인 경우
			case	"*":
//				Calc클래스의 mul메서드 호출
				calc.mul();
				break;
				
//			'/'기호인 경우
			case	"/":
//				Calc클래스의 div메서드 호출
				calc.div();
				break;
			default:
				break;
			}
//			연산 결과를 msg변수에 저장
			msg="<h1> 결과: "+result+"</h1>";
		} catch (ArithmeticException e) {
			
//			0으로 나눔
			msg="<h1 style='color:red'> 0으로 나눌 수 없습니다.</h1>";
//			2개 이상의 연산자나 3개 이상의 입력값이 입력될 때 발생하는 예외
		} catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
			msg="<h1 style='color:red>잘못된 수식입니다.</h1>";
		}
		
//		스트림에 텍스트 기록
		out.print(msg);
		out.print("<a href='calc'>다시 계산하기</a>");
		
//		스트림의 내용을 flush메서드를 통해 요청한 client에게 전달해주고 사용된 자원을 반환
		out.close();
	}

}
