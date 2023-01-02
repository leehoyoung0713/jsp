package com.koreait.app;

// Calc 클래스 선언
public class Calc {
	
//	두 정수의 연산을 위한 int형 변수 2개 선언
	public int number1;
	public int number2;
	
//	기본 생성자 선언
	public Calc() {;}
	
//	int 타입의 매개변수가 2개인 생성자 선언
	public Calc(int number1,int number2) {
		super();
		this.number1=number1;
		this.number2=number2;
	}
	
//	String 타입의 매개변수가 2개인 생성자 선언
	public Calc(String number1,String number2) {
		this(Integer.parseInt(number1),Integer.parseInt(number2));	
	}
	
//	사칙연산을 위한 메서드 선언
	public int add() {return number1+number2;}
	public int sub() {return number1-number2;}
	public int mul() {return number1*number2;}
	public int div() {return number1/number2;}
}
