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
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Orders")
@Entity
@Getter @Setter
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name = "ORDERS_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name= "PERSON_ID")
	@Setter(AccessLevel.NONE)
	private Person person;

	public void setMember(Person person){
      person.getOrders().add(this);
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




