package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.koreait.mybatis.config.MyBatisConfig;

import vo.UserVO;

//화면에서 입력받는 데이터 처리를 위한 DAO 클래스 선언
public class UserDAO {
	
//	모든 메서드에서 사용되어야할 Connection, PreparedStatement, ResultSet 객체 선언 및 초기화
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;
	public SqlSession sqlSession;
	
//	SQLSession객체 생성하는 기본 생성자 선언
	public UserDAO() {
		sqlSession=MyBatisConfig.getSqlsessionFactory().openSession(true);
	}
	
//	아이디 중복검사를 하며 있으면 true, 없으면 false를 반환
	public boolean checkId(String userId) {
		return (Integer)sqlSession.selectOne("User.checkId",userId)==1;
	}
	
//	public boolean checkId(String name) {
//		String query="select count(user_number) from tbl_user where user_id=?";
//		boolean check=false;
//		
//		try {
//			connection=DBConnecter.getConnection();
//			preparedStatement=connection.prepareStatement(query);
//			preparedStatement.setString(1, name);
//			resultSet=preparedStatement.executeQuery();
//			
//			resultSet.next();
//			check=resultSet.getInt(1)==1;
//		} catch (SQLException e) {
//			System.out.println("문법 오류");
//			e.printStackTrace();
//		} catch(Exception e) {
//			System.out.println("알 수 없는 오류");
//		} finally {
//			try {
//				if(resultSet!=null)resultSet.close();
//				if(preparedStatement!=null)preparedStatement.close();
//				if(connection!=null)connection.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e.getMessage());
//			}
//		}
//		return check;
//		
//	}
	
	//회원가입
	public void insert(UserVO userVO) {
		
//		연결 객체를 통해 메서드 실행
		sqlSession.insert("User.insert",userVO);
	}
//	public void join(UserVO userVO) {
//		String query="insert into tbl_user (user_id) values (?)";
//		
//		try {
//			connection=DBConnecter.getConnection();
//			preparedStatement=connection.prepareStatement(query);
//			preparedStatement.setString(1, userVO.getUserName());
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println("join() 오류");
//		} finally {
//			try {
//				if(preparedStatement!=null)preparedStatement.close();
//				if(connection!=null)connection.close();
//			} catch (SQLException e) {
//				throw new RuntimeException(e.getMessage());
//			}
//		}
//	}
}
