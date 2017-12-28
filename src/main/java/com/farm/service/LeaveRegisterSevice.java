package com.farm.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.exception.FarmAppException;
import com.farm.persistence.util.LeaveJPAPersistence;
import com.farm.rest.dto.LeaveRequestDto;
import com.farm.rest.dto.LeaveRequestDto.LeaveStatus;

@Component
public class LeaveRegisterSevice {

	@Autowired
	private LeaveJPAPersistence leaveJPAPersistence;

	public List<LeaveRequestDto> getLeaveEntries(String userId) {
		return leaveJPAPersistence.getLeaveEntries(userId);
	}

	public List<LeaveRequestDto> getLeaveEntries(String userId, Date startDate) {
		return leaveJPAPersistence.getLeaveEntries(userId, startDate);
	}

	public LeaveRequestDto addLeaveEntry(LeaveRequestDto leaveRequest) throws FarmAppException {
		return leaveJPAPersistence.addLeave(leaveRequest);
	}

	public LeaveRequestDto updateLeaveEntry(LeaveRequestDto leaveRequest) {
		return leaveJPAPersistence.updateLeave(leaveRequest);
	}

	public LeaveRequestDto updateLeaveStatus(Long leaveId, LeaveStatus status) {
		return leaveJPAPersistence.updateLeaveStatus(leaveId, status);
	}

}
