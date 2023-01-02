package com.koreait.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
/* @WebServlet("/Hello") */
// 사용자의 요청을 처리하기 위한 HttpServlet 클래스 상속
public class MyServlet extends HttpServlet {
//	직렬화를 통해 유효한 파일인지 확인하기 위한 설정(필수)
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
//	HttpServlet기본 생성자 호출
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
//  Get요청이 들어왔을때 처리하기 위한 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("userName"));
		
//		getParameter 메서드를 통해 키값에 해당하는 "userName"의 value값을 name변수에 저장
		String name=request.getParameter("userName");

//		요청한 client에 내용을 전달할때 사용하는 타입 설정
		response.setContentType("text/html; charset=UTF-8");
		
//		Servlet으로 들어온 요청을 텍스트 형태로 응답하기 위해 출력스트림을 얻어야하므로 getWriter()메서드 사용[바이트를 문자 형태를 가지는 객체로 바꿔준다]
		PrintWriter out=response.getWriter();
		
//		스트림에 텍스트 기록
		out.print("<div style='text-align:right;'>"+name+"님 환영합니다.");
		out.print("<h1>서블릿으로 만든 페이지</h1>");
		out.print("<a href='index'>JSP로 이동!</a>");
		
//		스트림의 내용을 flush메서드를 통해 요청한 client에게 전달해주고 사용된 자원을 반환
		out.close();
	}

}
