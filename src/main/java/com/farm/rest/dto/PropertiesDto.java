package com.farm.rest.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertiesDto {

	private String appName;
	private String version;
	private Map<String, String> famTypes = new HashMap<String, String>();
	private Map<String, String> employeeTypes = new HashMap<String, String>();
	private Map<String, String> countries = new HashMap<String, String>();
	private Map<String, List<String>> states = new HashMap<>();

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Map<String, String> getFamTypes() {
		return famTypes;
	}

	public void setFamTypes(Map<String, String> famTypes) {
		this.famTypes = famTypes;
	}

	public Map<String, String> getEmployeeTypes() {
		return employeeTypes;
	}

	public void setEmployeeTypes(Map<String, String> employeeTypes) {
		this.employeeTypes = employeeTypes;
	}

	public Map<String, String> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}

	public Map<String, List<String>> getStates() {
		return states;
	}

	public void setStates(Map<String, List<String>> states) {
		this.states = states;
	}
}
