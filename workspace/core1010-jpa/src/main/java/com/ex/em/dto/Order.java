package com.ex.em.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
public class Order {
	
	@Id
	@GeneratedValue 	// 전략 생략, AUTO
	@Column(name="ORDER_ID")
	private Long id;
	@Column(name = "MEMBER_ID")
	private Long memberId;
	private LocalDateTime orderDate;
	private String status;
	

}




