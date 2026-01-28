package com.yatish;

public class MainApp {
	public static void main(String[] args) {
		doCalculate(null);
	}
	public static void doCalculate(calculator calculator) {
		calculator.calc();
	}
}


interface calculator{
	void calc();
}