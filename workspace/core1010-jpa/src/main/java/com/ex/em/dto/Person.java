package com.ex.em.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.ex.em.dto.emb.Address;
import com.ex.em.dto.emb.Period;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@SequenceGenerator(name = "PERSON_SEQ_GENERATOR",sequenceName="PERSON_SEQ",
   initialValue = 1, allocationSize = 1)
@Getter @Setter @ToString
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ_GENERATOR")
   @Column(name = "PERSON_ID")
   private Long id;

   @Column(name = "USERNAME")
   private String name;

   @OneToMany(mappedBy = "person")
   private List<Order> orders = new ArrayList<>();
   
   public void addOrder(Order order){
      order.setMember(this);
      this.orders.add(order);
   }

   @Embedded
   private Address address;

   @Embedded
   @AttributeOverrides({
      @AttributeOverride(name = "city", column = @Column(name="WORK_CITY")),
      @AttributeOverride(name = "street", column = @Column(name="WORK_STREET")),
      @AttributeOverride(name = "zipcode", column = @Column(name="WORK_ZIPCODE"))
   })
   private Address workAddress;

   @Embedded
   private Period period;
}
