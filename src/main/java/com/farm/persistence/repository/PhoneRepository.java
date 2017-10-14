package com.farm.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.farm.persistence.entity.PhoneDetailsEntity;
import com.farm.persistence.entity.UserEntity;

public interface PhoneRepository extends CrudRepository<PhoneDetailsEntity, Long> {

	PhoneDetailsEntity findByNumber(String firstName);

	List<PhoneDetailsEntity> findByUser(UserEntity userEntity);

	@Modifying
	@Query(nativeQuery=true,value="delete from phone_details  where phone_user_id = :userId")
	public void deleteByUserId(@Param("userId") String userId);

}