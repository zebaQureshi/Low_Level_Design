package com.splitwise.model;

public class User {

	private String id;
	private String name;
	private Long mobile;
	private String email;

	public String getName() {
		return name;
	}

	public Long getMobile() {
		return mobile;
	}

	public String getEmail() {
		return email;
	}

	public String getId() {
		return id;
	}



	public User(String id,String name, Long mobile, String email) {
		this.id=id;
		this.name = name;
		this.mobile = mobile;
		this.email = email;

	}

}
