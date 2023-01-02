package vo;

//GuestVO 클래스 타입의 모델 객체 선언
public class GuestVO {
	
//	멤버 변수 선언 및 초기화
	private int guestNumber;
	private String guestName;
	private String guestBirth;
	
//	기본 생성자 선언
	public GuestVO() {;}

//	getter,setter 메서드 선언
	public int getGuestNumber() {
		return guestNumber;
	}

	public void setGuestNumber(int guestNumber) {
		this.guestNumber = guestNumber;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestBirth() {
		return guestBirth;
	}

	public void setGuestBirth(String guestBirth) {
		this.guestBirth = guestBirth;
	}

//	toString메서드 재정의
	@Override
	public String toString() {
		return "GuestVO [guestNumber=" + guestNumber + ", guestName=" + guestName + ", guestBirth=" + guestBirth
				+ "]";
	}
	
}
