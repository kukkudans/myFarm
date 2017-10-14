package com.farm.persistence.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.farm.persistence.entity.UserCredentialEntity;
import com.farm.persistence.entity.UserEntity;

public interface UserCredentialRepository extends CrudRepository<UserCredentialEntity, Long> {

	@Modifying
	@Query("update UserCredentialEntity u set u.password = :newPassword  where u.user.userId= :userId")
	UserEntity updatePassword(@Param("userId") String userId, @Param("newPassword") String password);

	@Query("select u.user from UserCredentialEntity u where u.user.userId = :userId and u.password = :password")
	UserEntity authenticate(@Param("userId") String userId, @Param("password") String password);

}