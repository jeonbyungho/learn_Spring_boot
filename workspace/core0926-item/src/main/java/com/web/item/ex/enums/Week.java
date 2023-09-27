package com.web.item.ex.enums;

public enum Week {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
	
	// enum 타입은 메서드를 가질 수 있다.
	public void dayInfo() {
		System.out.println("call day info : " + this.name());
	}
}
