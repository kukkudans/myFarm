package com.farm.rest.dto.response;

import com.farm.rest.dto.UserDto;

public class FarmLoginResponseDto extends BaseResponse {


	public FarmLoginResponseDto() {
		super();
	}

	private String token;
	private UserDto user;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
}
