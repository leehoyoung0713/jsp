package com.koreait.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuestDAO;
import vo.GuestVO;

/**
 * Servlet implementation class GuestServlet
 */
/* @WebServlet("/guest") */

// 사용자의 요청을 처리하기 위해 HttpServlet 클래스를 상속
public class GuestServlet extends HttpServlet {
	
//	직렬화를 통해 유효한 파일인지 확인하기 위한 설정(필수)
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
//	HttpServlet 기본 생성자 호출
    public GuestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
//    post요청을 처리하기 위한 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		client로부터 요청을 응답받을때 사용하는 타입 설정
		request.setCharacterEncoding("utf-8");
		
//		요청한 client에 내용을 전달할때 사용하는 타입 설정
		response.setContentType("text/html; charset=utf-8");
		
//		"name"에 해당하는 parameter값을 name문자열 변수에 저장
		String name=request.getParameter("name");
		
//		화면으로부터 입력받는 데이터를 처리하기 위한 GuestDAO 객체 생성
		GuestDAO guestDAO=new GuestDAO();
		System.out.println("name:"+name);
		
//		동명이인의 이름이 있을 수 있으므로 ArrayList<GueestVO>타입의 변수 선언 및 초기화
		ArrayList<GuestVO> guests=guestDAO.selectUsers(name);
		
//		Servlet으로 들어온 요청을 텍스트 형태로 응답하기 위해 출력스트림을 얻기 위한 getWriter 메서드 사용
		PrintWriter out=response.getWriter();
		
//		스트림에 텍스트 기록
		out.print("<table>");
		for(int i=0;i<guests.size();i++) {
			out.print("<tr>");
				out.print("<td>"+guests.get(i).getGuestNumber()+"</td>");
				out.print("<td>"+guests.get(i).getGuestName()+"</td>");
				out.print("<td>"+guests.get(i).getGuestBirth()+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("<a href='search'>다시 조회</a>");
		
//		flush메서드를 통해 출력 스트림의 내용을 전송하고 사용되었던 자원을 반환
		out.close();
	}

}
