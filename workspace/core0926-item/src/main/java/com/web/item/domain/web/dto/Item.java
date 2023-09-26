package com.web.item.domain.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Item {
	private Long id;
	private String itemName;
	private Integer price;
	private Integer quantity;
	
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
		
	}
}
