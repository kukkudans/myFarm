package com.farm.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.persistence.entity.UserEntity;
import com.farm.persistence.users.UsersTransformer;
import com.farm.persistence.util.UserJPAPersistence;
import com.farm.rest.dto.UserDto;
import com.farm.rest.dto.UserLoginRequestDto;
import com.farm.rest.dto.response.FarmLoginResponseDto;
import com.farm.service.util.SessionHelper;

@Component
public class UserAuthenticationSevice {

	@Autowired
	private UserJPAPersistence userJPAPersistence;

	@Autowired
	private UsersTransformer transformer;

//	@Autowired
//	private HttpSessionSecurityContextRepository sessionRepository;

	@Autowired
	private SessionHelper session;

	public FarmLoginResponseDto authenticate(UserLoginRequestDto loginRequest) {
		FarmLoginResponseDto response = new FarmLoginResponseDto();

		UserEntity userEntity = userJPAPersistence.authenticate(loginRequest.getUserId(), loginRequest.getPassword());
		if (null == userEntity) {

			response.setNotFound(true);
			return response;
		}
		String authToken = UUID.randomUUID().toString();
		UserDto user = transformer.fromEntity(userEntity);

		response.setUser(user);
		response.setToken(authToken);
		session.setLoginSession(response);
		return response;
	}

}
