package com.farm.rest;

import java.util.List;

import javax.ws.rs.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.exception.FarmAppException;
import com.farm.rest.dto.UserDto;
import com.farm.rest.dto.response.FarmBaseResponse;
import com.farm.service.UserSevice;

@RestController
public class FarmUserController {

	@Autowired
	private UserSevice service;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getUsers() {

		List<UserDto> users = service.getUsers();
		return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseEntity<FarmBaseResponse<String>> addUser(@RequestBody UserDto user) {

		try {
			service.addUser(user);
			return new ResponseEntity<FarmBaseResponse<String>>(new FarmBaseResponse<>("Successfully added user"),
					HttpStatus.OK);
		} catch (FarmAppException e) {
			FarmBaseResponse<String> response = new FarmBaseResponse<>(e.getMessage());
			response.setHasConflict(true);
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	public ResponseEntity<FarmBaseResponse<UserDto>> updateUser(@RequestBody UserDto user) {

		try {
			service.updateUser(user);
			return new ResponseEntity<FarmBaseResponse<UserDto>>(new FarmBaseResponse<>("Successfully updated user"),
					HttpStatus.OK);
		} catch (NotFoundException e) {
			FarmBaseResponse<String> response = new FarmBaseResponse<>(e.getMessage());
			response.setNotFound(true);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<FarmBaseResponse<String>> deleteUser(@PathVariable("userId") String userId) {

		service.deleteUser(userId);
		return new ResponseEntity<FarmBaseResponse<String>>(new FarmBaseResponse<>("deleted successfully"),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<FarmBaseResponse<UserDto>> readUser(@PathVariable("userId") String userId) {
		try {
			UserDto user = service.getUser(userId);
			return new ResponseEntity<FarmBaseResponse<UserDto>>(new FarmBaseResponse<>(user), HttpStatus.OK);
		} catch (NotFoundException e) {
			FarmBaseResponse<String> response = new FarmBaseResponse<>(e.getMessage());
			response.setNotFound(true);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}