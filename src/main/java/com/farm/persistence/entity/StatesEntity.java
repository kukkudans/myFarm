package com.farm.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "states")
public class StatesEntity {

	@Id
	@Column(name = "state_id")
	private Long stateId;

	@Column(name = "state_code")
	@NotNull
	private String stateCode;

	@Column(name = "state_name")
	@NotNull
	private String stateName;

	@NotNull
	@Column(name = "country_code")
	private String country;

	public StatesEntity() {
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}