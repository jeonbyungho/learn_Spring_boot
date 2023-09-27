package com.web.item.ex.enums;

public class App02 {
	public static void main(String[] args) {
		Season season = Season.SPRING;
		// 해당 열거 객체의 문자열을 반환한다.
		String name = season.name();
		System.out.println("season name : " + name);
		
		// 해당 열거 객체가 몇 번째인지를 int로 반환한다.
		int ordinal = season.ordinal();
		System.out.println("season ordinal : " + ordinal);
		
		// 열거 타입의 모든 열거 객체들을 배열로 만들어 반환한다.
		Season[] arr = Season.values();
		for(Season s : arr) System.out.println(s.ordinal() + ":" + s);
	}
}
