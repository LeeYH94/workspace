package com.koreait.calculator;
	
public class Calc {
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public int sub(int num1, int num2) {
		return num1 - num2;
	}
	
	public int mul(int num1, int num2) {
		return num1 * num2;
	}
	
	/**
	 * @throws ArithmeticException
	 */
	public int div(int num1, int num2) throws ArithmeticException {
		if(num2 == 0) {
			throw new ArithmeticException();
		}
		return num1/num2;
	}
}
