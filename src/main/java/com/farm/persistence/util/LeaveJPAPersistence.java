package com.farm.persistence.util;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.exception.FarmAppException;
import com.farm.persistence.entity.LeaveRegisterEntity;
import com.farm.persistence.repository.LeaveRegisterRepository;
import com.farm.persistence.users.LeaveRegisterTransformer;
import com.farm.rest.dto.LeaveRequestDto;
import com.farm.rest.dto.LeaveRequestDto.LeaveStatus;

@Component
public class LeaveJPAPersistence {

	@Autowired
	private LeaveRegisterRepository leaveRegisterRepository;

	@Autowired
	private LeaveRegisterTransformer leaveRegisterTransformer;

	public List<LeaveRequestDto> getLeaveEntries(String userId) {
		List<LeaveRegisterEntity> leaveList = leaveRegisterRepository.findByUserId(userId);

		return leaveRegisterTransformer.fromEntities(leaveList);
	}

	public LeaveRequestDto addLeave(LeaveRequestDto leaveRequest) throws FarmAppException {
		LeaveRegisterEntity leaveEntity = leaveRegisterTransformer.toEntity(leaveRequest);

		if (leaveRegisterRepository.isAlreadyApplied(leaveEntity.getUserId(), leaveEntity.getStartDate())) {
			throw new FarmAppException(String.format("Leave already applied %s", leaveEntity.getStartDate()));
		}
		leaveEntity = leaveRegisterRepository.save(leaveEntity);

		return leaveRegisterTransformer.fromEntity(leaveEntity);
	}

	public List<LeaveRequestDto> getLeaveEntries(String userId, Date startDate) {

		List<LeaveRegisterEntity> leaveList = leaveRegisterRepository.findLeavesFromStartDate(userId, startDate);

		return leaveRegisterTransformer.fromEntities(leaveList);
	}

	public LeaveRequestDto updateLeave(LeaveRequestDto leaveRequest) {
		LeaveRegisterEntity leaveEntity = leaveRegisterRepository.findById(leaveRequest.getLeaveId());

		LeaveRegisterEntity updatedEntity = leaveRegisterTransformer.toEntity(leaveRequest);
		BeanUtils.copyProperties(updatedEntity, leaveEntity, "id", "userId");

		updatedEntity = leaveRegisterRepository.save(leaveEntity);
		return leaveRequest;
	}

	public LeaveRequestDto updateLeaveStatus(Long leaveId, LeaveStatus status) {
		LeaveRegisterEntity leaveEntity = leaveRegisterRepository.findById(leaveId);
		leaveEntity.setStatus(status.toString());

		return leaveRegisterTransformer.fromEntity(leaveEntity);
	}

}
