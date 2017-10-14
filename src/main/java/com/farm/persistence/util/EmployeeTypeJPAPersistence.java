package com.farm.persistence.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.persistence.entity.EmployeeTypeEntity;
import com.farm.persistence.repository.EmployeeTypeRepository;

@Component
public class EmployeeTypeJPAPersistence {

	@Autowired
	private EmployeeTypeRepository employeeTypeRepo;

	public List<EmployeeTypeEntity> getEmployeeTypes() {
		return  (List<EmployeeTypeEntity>)employeeTypeRepo.findAll();
	}
}
