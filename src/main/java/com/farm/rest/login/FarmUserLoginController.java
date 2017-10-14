package com.farm.rest.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.rest.dto.UserLoginRequestDto;
import com.farm.rest.dto.response.BaseResponse;
import com.farm.rest.dto.response.FarmLoginResponseDto;
import com.farm.service.UserAuthenticationSevice;
import com.farm.service.util.SessionHelper;

@RestController
public class FarmUserLoginController {

	@Autowired
	private UserAuthenticationSevice authService;

	@Autowired
	private SessionHelper session;

	@RequestMapping(value = "/user/auth", method = RequestMethod.POST)
	public ResponseEntity<FarmLoginResponseDto> addUser(@RequestBody UserLoginRequestDto loginRequest) {

		FarmLoginResponseDto response = authService.authenticate(loginRequest);
		return new ResponseEntity<FarmLoginResponseDto>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/auth", method = RequestMethod.GET)
	public ResponseEntity<FarmLoginResponseDto> getUser() {

		return new ResponseEntity<FarmLoginResponseDto>(session.getLoginSession(), HttpStatus.OK);
	}

	@RequestMapping(value = "/user/logOff", method = RequestMethod.POST)
	public ResponseEntity<BaseResponse> logOff() {

		session.setLoginSession(null);
		return new ResponseEntity<BaseResponse>(new BaseResponse("Logged out successfully"), HttpStatus.OK);
	}

}