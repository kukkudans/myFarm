package com.farm.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farm_type")
public class FarmTypeEntity {

	@Id
	@Column(name = "farm_type_id")
	private Long farmTypeId;

	@Column(name = "farm_type")
	private String farmType;

	@Column(name = "description")
	private String description;

	public Long getFarmTypeId() {
		return farmTypeId;
	}

	public void setFarmTypeId(Long farmTypeId) {
		this.farmTypeId = farmTypeId;
	}

	public String getFarmType() {
		return farmType;
	}

	public void setFarmType(String farmType) {
		this.farmType = farmType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
