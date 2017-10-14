package com.farm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.farm.persistence.entity.CountryEntity;
import com.farm.persistence.entity.EmployeeTypeEntity;
import com.farm.persistence.entity.FarmTypeEntity;
import com.farm.persistence.entity.StatesEntity;
import com.farm.persistence.util.EmployeeTypeJPAPersistence;
import com.farm.persistence.util.FarmTypeJPAPersistence;
import com.farm.persistence.util.PropertiesJPAPersistence;
import com.farm.rest.dto.PropertiesDto;

@Component
public class PropertiesService {

	@Value("${farm.version}")
	private String versionNo;

	@Value("${farm.name}")
	private String appName;

	private PropertiesDto properties;

	@Autowired
	private FarmTypeJPAPersistence farmTypeJpaPersistence;

	@Autowired
	private EmployeeTypeJPAPersistence employeeTypeJPAPersistence;

	@Autowired
	private PropertiesJPAPersistence propertiesJPAPersistence;

	@PostConstruct
	public void init() {
		constructProperties();
	}

	public PropertiesDto getProperties() {

		return properties;

	}

	private PropertiesDto constructProperties() {
		properties = new PropertiesDto();
		properties.setAppName(appName);
		properties.setVersion(versionNo);

		addFarmTypes(properties);
		addEmployeeTypes(properties);
		addCountries(properties);
		return properties;
	}

	private void addCountries(PropertiesDto properties) {

		Map<String, List<String>> statesMap = new HashMap<>();
		List<CountryEntity> countryList = propertiesJPAPersistence.getCountries();
		Map<String, String> countryeMap = countryList.stream()
				.collect(Collectors.toMap(CountryEntity::getCountryCode, CountryEntity::getCountryName));

		countryList.stream().forEach(e -> {
			statesMap.put(e.getCountryName(), getStatesList(e.getCountryCode()));
		});

		properties.setStates(statesMap);
		properties.setCountries(countryeMap);
	}

	private List<String> getStatesList(String countryCode) {
		return propertiesJPAPersistence.getStates(countryCode).stream().map(StatesEntity::getStateName)
				.collect(Collectors.toList());
	}

	private void addEmployeeTypes(PropertiesDto prop) {
		List<EmployeeTypeEntity> employeeTypes = employeeTypeJPAPersistence.getEmployeeTypes();
		Map<String, String> employeeTypeMap = employeeTypes.parallelStream().collect(
				Collectors.toMap(EmployeeTypeEntity::getEmployeeType, EmployeeTypeEntity::getEmployeeTypeDescription));
		prop.setEmployeeTypes(employeeTypeMap);
	}

	private void addFarmTypes(PropertiesDto prop) {
		List<FarmTypeEntity> farmTypes = farmTypeJpaPersistence.getFarmTypes();
		Map<String, String> farmTypeMap = farmTypes.parallelStream()
				.collect(Collectors.toMap(FarmTypeEntity::getFarmType, FarmTypeEntity::getDescription));
		prop.setFamTypes(farmTypeMap);
	}
}
