package com.farm.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.farm.persistence.entity.CountryEntity;

public interface CountryRepository extends CrudRepository<CountryEntity, Long> {


}