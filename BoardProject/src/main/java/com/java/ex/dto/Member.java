package com.java.ex.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Member {
	
	private String user_id;
	private String user_pwd;
	private String user_name;
	private String user_katakana;
	
	private Date user_birth;
	private Timestamp user_indate;
	
	
	
	
	
	
	public Member(String user_id, String user_pwd, String user_name, String user_katakana, Date user_birth) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.user_katakana = user_katakana;
		this.user_birth = user_birth;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_katakana() {
		return user_katakana;
	}
	public void setUser_katakana(String user_katakana) {
		this.user_katakana = user_katakana;
	}
	public Date getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}
	public Timestamp getUser_indate() {
		return user_indate;
	}
	public void setUser_indate(Timestamp user_indate) {
		this.user_indate = user_indate;
	}
	
	
	
}
