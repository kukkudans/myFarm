package com.farm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.rest.dto.UserAddressDto;
import com.farm.rest.dto.response.FarmBaseResponse;
import com.farm.service.UserSevice;

@RestController
public class FarmUserAddressController {

	@Autowired
	private UserSevice service;

	@RequestMapping(value = "/user/{userId}/address", method = RequestMethod.GET)
	public ResponseEntity<FarmBaseResponse<UserAddressDto>> getAddress(@PathVariable("userId") String userId) {

		UserAddressDto user = service.getUserAddress(userId);
		return new ResponseEntity<FarmBaseResponse<UserAddressDto>>(new FarmBaseResponse<>(user), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{userId}/address", method = RequestMethod.PUT)
	public ResponseEntity<FarmBaseResponse<UserAddressDto>> updateAddress(@PathVariable("userId") String userId,@RequestBody UserAddressDto addressDto) {
		
		UserAddressDto user = service.updateUserAddress(userId, addressDto);
		return new ResponseEntity<FarmBaseResponse<UserAddressDto>>(new FarmBaseResponse<>(user,"Updated successfully"), HttpStatus.OK);
	}
}