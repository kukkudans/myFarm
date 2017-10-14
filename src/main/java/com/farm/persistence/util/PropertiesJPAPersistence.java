package com.farm.persistence.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.persistence.entity.CountryEntity;
import com.farm.persistence.entity.StatesEntity;
import com.farm.persistence.repository.CountryRepository;
import com.farm.persistence.repository.StatesRepository;

@Component
public class PropertiesJPAPersistence {

	@Autowired
	private StatesRepository stateRepo;

	@Autowired
	private CountryRepository countryRepo;

	public List<StatesEntity> getStates() {
		return (List<StatesEntity>) stateRepo.findAll();
	}
	
	public List<StatesEntity> getStates(String countryCode) {
		return (List<StatesEntity>) stateRepo.getStatesByStateCode(countryCode);
	}

	public List<CountryEntity> getCountries() {
		return (List<CountryEntity>) countryRepo.findAll();
	}
}
