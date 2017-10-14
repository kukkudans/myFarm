package com.farm.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.farm.persistence.entity.FarmTypeEntity;

public interface FarmTypeRepository extends CrudRepository<FarmTypeEntity, Long> {


}