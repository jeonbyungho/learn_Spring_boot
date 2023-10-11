package com.ex.em.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Orders {
	
	@Id
	@GeneratedValue
	@Column(name = "ORDERS_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name= "MEMBER_ID")
	@Setter(AccessLevel.NONE)
	private Person person;

	public void setMember(Person person){
      person.getOrderss().add(this);
      this.person = person;
   }

	private LocalDateTime orderDate;
	
	private String status;

	@OneToMany(mappedBy="orders")
	List<OrderItem> orderItems = new ArrayList<>();
	public void addOrderItems(OrderItem orderItem){
		orderItem.setOrders(this);
		this.orderItems.add(orderItem);
	}

	

	

}




