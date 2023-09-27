package com.web.item.domain.web.dto;

import java.util.List;

import com.web.item.domain.web.dto.enums.ItemType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Item {
	private Long id;
	private String itemName;
	private Integer price;
	private Integer quantity;
	
	private Boolean open;			// 판매 여부
	private List<String> regions;	// 등록 지역
	private ItemType itemType;		// 상품 종류
	private String deliveryCode;		// 배송 방식
	
	public Item(Long id, String itemName, Integer price, Integer quantity) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Item(String itemName, Integer price, Integer quantity) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Item() {
		super();
	}
}
