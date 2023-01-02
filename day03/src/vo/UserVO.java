package vo;

//UserVO 클래스 타입의 모델 객체 선언
public class UserVO {
	
//	멤버 변수 선언 및 초기화
	private int userNumber;
	private String userName;
	
//	기본 생성자 선언
	public UserVO() {;}

//	getter,setter 메서드 선언
	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

//	toString메서드 재정의
	@Override
	public String toString() {
		return "UserVO [userNumber=" + userNumber + ", userName=" + userName +"]";
	}

}
