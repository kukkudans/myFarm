package com.farm.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.farm.persistence.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByUserId(String userId);
	
	List<UserEntity> findByFirstName(String firstName);

	UserEntity findByFirstNameAndLastName(String firstName, String lastName);

	List<UserEntity> findByLastName(String lastName);
}