package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//db연결을 위한 클래스 생성(매 요청시마다 사용되며, 다른 DAO파일에서도 사용되야 하므로 클래스 및 static 메서드 생성)
public class DBConnecter {
	public static Connection getConnection() {
		
//		connection객체를 사용하기 위한 초기화
		Connection connection=null;
		
//		DB와 연결시 생길 수 있는 예외로 인한 try-catch구문으로 구성
		try {
			
//			mysql db에서 사용하는 database와 계정의 정보 작성
			String url="jdbc:mysql://localhost:3306/jsp";
			String id="root";
			String pw="1234";
			
//			mysql의 드라이버 경로 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			작성해둔 정보를 토대로 드라이버 연결
			connection=DriverManager.getConnection(url,id,pw);
			
//			드라이버 클래스 파일을 찾지 못할때 발생하는 예외
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 오류");
			
//			SQL 문의 오류로 발생하는 예외
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("문법 오류");
			
//			기타 예외 발생 처리를 위한 구문
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("알 수 없는 오류");
		}
		
//		연결된 객체의 주소를 반환
		return connection;
	}
}
