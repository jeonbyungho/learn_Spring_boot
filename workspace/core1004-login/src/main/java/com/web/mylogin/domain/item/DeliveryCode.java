package com.web.mylogin.domain.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @AllArgsConstructor	: 모든 필드 값을 파라미터를 받는 생성자 생성.
 * @NoArgsConstructor 	: 파라미터가 없는 기본 생성자를 생성.
 * */
@Getter @Setter @ToString @AllArgsConstructor
public class DeliveryCode {
	/*
	 * FAST 	: 빠른 배송
	 * NORMAL 	: 일반 배송
	 * SLOW 	: 느린 배송
	 */
	
	private String code;
	private String displayName;
}