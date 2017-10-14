package com.farm.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.farm.persistence.entity.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

	@Query("select a from AddressEntity a where a.user = :userId")
	AddressEntity findByUserId(@Param("userId") String userId);

}