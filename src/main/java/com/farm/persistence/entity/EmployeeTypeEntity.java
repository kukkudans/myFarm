package com.farm.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farm_employee_types")
public class EmployeeTypeEntity {

	@Id
	@Column(name = "farm_employee_type_id")
	private Long employeeTypeId;

	@Column(name = "farm_employee_type")
	private String employeeType;

	@Column(name = "farm_employee_type_desc")
	private String employeeTypeDescription;

	public Long getEmployeeTypeId() {
		return employeeTypeId;
	}

	public void setEmployeeTypeId(Long employeeTypeId) {
		this.employeeTypeId = employeeTypeId;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getEmployeeTypeDescription() {
		return employeeTypeDescription;
	}

	public void setEmployeeTypeDescription(String employeeTypeDescription) {
		this.employeeTypeDescription = employeeTypeDescription;
	}
	
	
}
