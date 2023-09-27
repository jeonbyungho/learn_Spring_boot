package com.web.item.ex.enums;

public class App03 {
	public static void main(String[] args) {
		for(Type type : Type.values()) {
			System.out.println(type.getName() + ":" +type.name());
		}
	}
}
