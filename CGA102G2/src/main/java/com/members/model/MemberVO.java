package com.members.model;

import java.sql.Blob;



public class MemberVO implements java.io.Serializable{
	private Integer member_id;
	private	String member_email;
	private	String member_password;
	private	String member_name;	
	private	String member_phone;
	private	String member_address;
	private byte[] member_pic;
	private	Integer member_status;
	
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public  String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public byte[] getMember_pic() {
		return member_pic;
	}
	public void setMember_pic(byte[] member_pic) {
		this.member_pic = member_pic;
	}
	public Integer getMember_status() {
		return member_status;
	}
	public void setMember_status(Integer member_status) {
		this.member_status = member_status;
	}
	
	@Override
	public String toString() {
		
		return 
				"member_id: " + member_id + "\n" 
				+ "member_email: " + member_email + "\n" 
				+ "member_password: " + member_password + "\n"
				+ "member_name: " + member_name + "\n"
				+ "member_phone: " + member_phone + "\n"
				+ "member_address: " + member_address + "\n"
				+ "member_pic: " + member_pic + "\n"
				+ "member_status: " + member_status;
				
	}
	
	
}
