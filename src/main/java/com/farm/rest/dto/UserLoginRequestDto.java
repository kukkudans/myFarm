package com.farm.rest.dto;

public class UserLoginRequestDto {
	private String userId;
	private String password;

	public UserLoginRequestDto() {
		super();
	}

	public UserLoginRequestDto(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
