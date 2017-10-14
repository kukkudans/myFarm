package com.farm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.rest.dto.PropertiesDto;
import com.farm.rest.dto.response.FarmBaseResponse;
import com.farm.service.PropertiesService;

@RestController
public class FarmPropertiesController {

	@Autowired
	private PropertiesService propertiesService;

	@RequestMapping(value = "/properties", method = RequestMethod.GET)
	public ResponseEntity<FarmBaseResponse<PropertiesDto>> getProperties() {

		PropertiesDto properties = propertiesService.getProperties();
		return new ResponseEntity<FarmBaseResponse<PropertiesDto>>(new FarmBaseResponse<>(properties), HttpStatus.OK);
	}
}