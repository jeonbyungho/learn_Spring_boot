package com.training.jpa01.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class People {
	@Id
	@GeneratedValue
	private Long idx;
	
	@Column(nullable = false, unique= true)
	private String id;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	private String birthday;
	private String gender;
	private String phone;
	private String email;
	private String postcode;
	private String address;
	
	public Long getIdx() {
		return idx;
	}
	public void setIdx(Long idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "People [idx=" + idx + ", id=" + id + ", password=" + password + ", name=" + name + ", birthday="
				+ birthday + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", postcode=" + postcode
				+ ", address=" + address + "]";
	}
}
