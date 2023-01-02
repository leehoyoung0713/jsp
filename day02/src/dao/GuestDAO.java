package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.GuestVO;

// 화면에서 입력받는 데이터 처리를 위한 DAO 클래스 선언
public class GuestDAO {
	
//	모든 메서드에서 사용되어야할 Connection, PreparedStatement, ResultSet 객체 선언 및 초기화
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	
//	전체 회원 목록
	public ArrayList<GuestVO> selectAll(){
		
//		tbl_guest테이블에서 전체 컬럼 조회(* 대신 각각의 컬럼을 설정한 이유는 연산 속도의 향상을 위함)
		String query="select guest_number,guest_name,guest_birth from tbl_guest";
		
//		ArrayList<GuestVO> 타입의 객체 생성
		ArrayList<GuestVO> guestVOs=new ArrayList();
		
//		연결이나 쿼리 전송시 발생할 수 있는 예외 때문에 try-catch구문으로 작성
		try {
			
//			db와 연결
			connection=DBConnecter.getConnection();
			
//			1. 캐시에 등록해놓고 재사용시 바인딩된 파라미터의 전달만으로 쿼리문의 실행 시간 단축을 위해 사용
//			2. sql Injection을 방어하기 위한 용도로도 사용
			preparedStatement=connection.prepareStatement(query);
			
//			select 쿼리문이므로 executeQuery메서드 사용
			resultSet=preparedStatement.executeQuery();
			
//			결과값으로 새로 생성된 스키마의 주소를 반환받고 다음 레코드를 읽어올 경우만 실행
			while(resultSet.next()) {
				
//				읽어온 레코드의 데이터를 저장하기 위해 GuestVO타입의 객체 생성
				GuestVO guestVO=new GuestVO();
				
//				쿼리문에서 지정했던 컬럼 순서로 타입에 맞는 값들을 읽어 객체에 저장
				guestVO.setGuestNumber(resultSet.getInt(1));
				guestVO.setGuestName(resultSet.getString(2));
				guestVO.setGuestBirth(resultSet.getString(3));
				
//				저장된 내용을 ArrayList<GuestVO> 타입의 객체에 저장
				guestVOs.add(guestVO);
			}
			
//		SQL문법 오류시 발생하는 예외 설정
		} catch (SQLException e) {
			System.out.println("문법 오류");
			e.printStackTrace();
			
//		나머지 예외에 대한 설정
		} catch(Exception e) {
			System.out.println("알 수 없는 오류");
			
//		예외와 상관없이 실행되는 구문
		} finally {
			
//			사용된 자원 반환을 위한 구문이며 내부 오류로 인해 반환이 되지 않을 수 있는 예외를 위한 try-catch구문
			try {
				
//				사용된 자원을 역순으로 반환
				if(resultSet!=null)resultSet.close();
				if(preparedStatement!=null)preparedStatement.close();
				if(connection!=null)connection.close();
				
//			자원 반환시 발생할 수 있는 예외 설정
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		
//		ArrayList<GuestVO> 타입의 객체 반환
		return guestVOs;
	}
	
//	사용자의 이름으로 회원들 조회(동명이인 경우도 있어서 ArrayList<GuestVO>의 반환타입 설정)
	public ArrayList<GuestVO> selectUsers(String name){
		
//		tbl_guest테이블에서 전체 컬럼 조회(* 대신 각각의 컬럼을 설정한 이유는 연산 속도의 향상을 위함)
		String query="select guest_number,guest_name,guest_birth from tbl_guest where guest_name=? ";
		
//		ArrayList<GuestVO> 타입의 객체 생성
		ArrayList<GuestVO> guestVOs=new ArrayList();
		
//		연결이나 쿼리 전송시 발생할 수 있는 예외 때문에 try-catch구문으로 작성
		try {
			
//			db와 연결
			connection=DBConnecter.getConnection();
			
//			1. 캐시에 등록해놓고 재사용시 바인딩된 파라미터의 전달만으로 쿼리문의 실행 시간 단축을 위해 사용
//			2. sql Injection을 방어하기 위한 용도로도 사용
			preparedStatement=connection.prepareStatement(query);
			
//			바인딩 파라미터를 매개변수로 입력받은 문자열 값으로 설정
			preparedStatement.setString(1, name);
			
//			select 쿼리문이므로 executeQuery메서드 사용
			resultSet=preparedStatement.executeQuery();
			
//			결과값으로 새로 생성된 스키마의 주소를 반환받고 다음 레코드를 읽어올 경우만 실행
			while(resultSet.next()) {
				
//				읽어온 레코드의 데이터를 저장하기 위해 GuestVO타입의 객체 생성
				GuestVO guestVO=new GuestVO();
				
//				쿼리문에서 지정했던 컬럼 순서로 타입에 맞는 값들을 읽어 객체에 저장
				guestVO.setGuestNumber(resultSet.getInt(1));
				guestVO.setGuestName(resultSet.getString(2));
				guestVO.setGuestBirth(resultSet.getString(3));
				
//				저장된 내용을 ArrayList<GuestVO> 타입의 객체에 저장
				guestVOs.add(guestVO);
			}
			
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
				throw new RuntimeException();
			}
		}
		
//		ArrayList<GuestVO> 타입의 객체 반환
		return guestVOs;
	}
	
//	회원들의 정렬을 위한 메서드이며 ArrayList<GuestVO> 반환 타입으로 설정
	public ArrayList<GuestVO> selectArrange(boolean asc){
		
//		매개변수로 전달받은 flag변수의 값의 여부로 쿼리문을 다르게 실행하게 설정
		String query="select guest_number,guest_name,guest_birth from tbl_guest ";
		query+=asc?"order by guest_number":"order by guest_number desc";
		
//		ArrayList<GuestVO> 타입의 객체 생성
		ArrayList<GuestVO> guestVOs=new ArrayList();
		
//		연결이나 쿼리 전송시 발생할 수 있는 예외 때문에 try-catch구문으로 작성
		try {
			
//			db와 연결
			connection=DBConnecter.getConnection();
			
//			1. 캐시에 등록해놓고 재사용시 바인딩된 파라미터의 전달만으로 쿼리문의 실행 시간 단축을 위해 사용
//			2. sql Injection을 방어하기 위한 용도로도 사용
			preparedStatement=connection.prepareStatement(query);
			
//			select 쿼리문이므로 executeQuery메서드 사용
			resultSet=preparedStatement.executeQuery();
			
//			결과값으로 새로 생성된 스키마의 주소를 반환받고 다음 레코드를 읽어올 경우만 실행
			while(resultSet.next()) {
				
//				읽어온 레코드의 데이터를 저장하기 위해 GuestVO타입의 객체 생성
				GuestVO guestVO=new GuestVO();
				
//				쿼리문에서 지정했던 컬럼 순서로 타입에 맞는 값들을 읽어 객체에 저장
				guestVO.setGuestNumber(resultSet.getInt(1));
				guestVO.setGuestName(resultSet.getString(2));
				guestVO.setGuestBirth(resultSet.getString(3));
				
//				저장된 내용을 ArrayList<GuestVO> 타입의 객체에 저장
				guestVOs.add(guestVO);
			}
			
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
				throw new RuntimeException();
			}
		}
		
//		ArrayList<GuestVO> 타입의 객체 반환
		return guestVOs;
	}
}
