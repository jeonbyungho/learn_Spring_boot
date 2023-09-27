package com.web.item.ex.enums;

public class App01 {
	public static void main(String[] args) {
		Week today = Week.MONDAY;
		System.out.println(today);
		
		Week.TUESDAY.dayInfo();
		Week.THURSDAY.dayInfo();
	}
}
