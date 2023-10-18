package com.ex.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name ="member")
@SequenceGenerator(
   name = "member_seq_generator", sequenceName = "member_seq",
   initialValue = 1, allocationSize = 1)
@Getter @Setter @ToString(exclude = "orders")
public class Member {
   
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
   @Column(name = "member_id")
   private Long id;

   private String name;

   @Embedded
   private Address address;

   @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
   private List<Order> orders = new ArrayList<Order>();
}
