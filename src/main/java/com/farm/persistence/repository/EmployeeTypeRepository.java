package com.farm.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.farm.persistence.entity.EmployeeTypeEntity;

public interface EmployeeTypeRepository extends CrudRepository<EmployeeTypeEntity, Long> {

}