package com.farm.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.farm.persistence.entity.StatesEntity;

public interface StatesRepository extends CrudRepository<StatesEntity, Long> {

	@Query("select s from StatesEntity s where s.country = :countryCode")
	List<StatesEntity> getStatesByStateCode(@Param("countryCode") String countryCode);
}