package com.training.membership.dto;

public class PersonLoginForm {
	private String userid;
	private String userpwd;
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
	@Override
	public String toString() {
		return "memberLoginForm [userid=" + userid + ", userpwd=" + userpwd + "]";
	}
}
