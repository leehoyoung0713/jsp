package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

//화면에서 입력받는 데이터 처리를 위한 DAO 클래스 선언
public class UserDAO {
	
//	모든 메서드에서 사용되어야할 Connection, PreparedStatement, ResultSet 객체 선언 및 초기화
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	
//	아이디 중복 체크를 위해 문자열 매개변수 전달받는 메서드 선언
	public boolean checkId(String name) {
		
//		바인딩 파라미터를 매개변수와 매핑하며, user_number컬럼의 수를 조회하는 쿼리문 작성
		String query="select count(user_number) from tbl_user where user_id=?";
		boolean check=false;
		
//		연결이나 쿼리 전송시 발생할 수 있는 예외 때문에 try-catch구문으로 작성
		try {
			
//			db와 연결
			connection=DBConnecter.getConnection();
			
//			1. 캐시에 등록해놓고 재사용시 바인딩된 파라미터의 전달만으로 쿼리문의 실행 시간 단축을 위해 사용
//			2. sql Injection을 방어하기 위한 용도로도 사용
			preparedStatement=connection.prepareStatement(query);
			
//			select 쿼리문이므로 executeQuery메서드 사용
			preparedStatement.setString(1, name);
			
//			select 쿼리문이므로 executeQuery메서드 사용
			resultSet=preparedStatement.executeQuery();
			
//			쿼리문의 결과값을 읽어서 조건식을 통해 check flag변수에 저장
			resultSet.next();
			check=resultSet.getInt(1)==1;
			
//			SQL문법 오류시 발생하는 예외 설정
		} catch (SQLException e) {
			System.out.println("문법 오류");
			e.printStackTrace();
			
//			나머지 예외에 대한 설정
		} catch(Exception e) {
			System.out.println("알 수 없는 오류");
			
//			예외와 상관없이 실행되는 구문
		} finally {
			
//			사용된 자원 반환을 위한 구문이며 내부 오류로 인해 반환이 되지 않을 수 있는 예외를 위한 try-catch구문
			try {
				
//				사용된 자원을 역순으로 반환
				if(resultSet!=null)resultSet.close();
				if(preparedStatement!=null)preparedStatement.close();
				if(connection!=null)connection.close();
				
//				자원 반환시 발생할 수 있는 예외 설정
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
//		flag 변수 반환
		return check;
		
	}
}
