package com.training.membership.dto;

public class MemberJoinForm {
	private String userid;
	private String userpwd;
	private String name;
	private String birthday;
	private String gender;
	private String phone;
	private String email;
	private String postcode;
	private String address;
	private String detailAddress;
	private String extraAddress;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
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
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	public String getExtraAddress() {
		return extraAddress;
	}
	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}
	@Override
	public String toString() {
		return "MemberForm [userid=" + userid + ", userpwd=" + userpwd + ", name=" + name + ", birthday=" + birthday
				+ ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", postcode=" + postcode
				+ ", address=" + address + ", detailAddress=" + detailAddress + ", extraAddress=" + extraAddress + "]";
	}
	
}
