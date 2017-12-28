package com.farm.persistence.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.farm.persistence.entity.LeaveRegisterEntity;

public interface LeaveRegisterRepository extends CrudRepository<LeaveRegisterEntity, Long> {

	List<LeaveRegisterEntity> findByUserId(String userId);

	LeaveRegisterEntity findById(Long id);

	@Query(value = "select l from LeaveRegisterEntity l where  l.userId = :userId and l.startDate >= :startDate")
	List<LeaveRegisterEntity> findLeavesFromStartDate(@Param("userId") String userId,
			@Param("startDate") Date startDate);

	@Query(value = "select case when count (l) = 0 then false else true end from LeaveRegisterEntity l where  l.userId = :userId and l.startDate = :startDate ")
	boolean isAlreadyApplied(@Param("userId") String userId, @Param("startDate") Date startDate);

	@Query(value = "select l from LeaveRegisterEntity l where  l.userId = :userId and l.startDate = :startDate ")
	LeaveRegisterEntity getLeaveEntry(@Param("userId") String userId, @Param("startDate") Date startDate);

}