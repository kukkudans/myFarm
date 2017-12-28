package com.farm.persistence.users;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.persistence.entity.LeaveRegisterEntity;
import com.farm.persistence.entity.UserEntity;
import com.farm.persistence.util.UserJPAPersistence;
import com.farm.rest.dto.LeaveRequestDto;
import com.farm.rest.dto.LeaveRequestDto.LeaveStatus;

@Component
public class LeaveRegisterTransformer {

	@Autowired
	private UserJPAPersistence userJPAPersistence;

	private Map<String, LeaveStatus> leaveStatusMap = new TreeMap<String, LeaveStatus>(String.CASE_INSENSITIVE_ORDER);

	@PostConstruct
	public void init() {
		leaveStatusMap.put("applied", LeaveStatus.APPLIED);
		leaveStatusMap.put("approved", LeaveStatus.APPROVED);
		leaveStatusMap.put("cancelled", LeaveStatus.CANCELLED);
		leaveStatusMap.put("rejected", LeaveStatus.REJECTED);

	}

	public LeaveRequestDto fromEntity(LeaveRegisterEntity entity) {
		LeaveRequestDto leaveDto = new LeaveRequestDto();
		BeanUtils.copyProperties(entity, leaveDto);
		leaveDto.setLeaveId(entity.getId());
		leaveDto.setStartDate(entity.getStartDate().toString());
		leaveDto.setEndDate(entity.getEndDate().toString());
		leaveDto.setCreatedDate(entity.getCreatedDate().toString());
		leaveDto.setStatus(leaveStatusMap.get(entity.getStatus()));

		setUserDetails(entity, leaveDto);
		return leaveDto;
	}

	public LeaveRegisterEntity toEntity(LeaveRequestDto leaveReqDto) {
		LeaveRegisterEntity leaveRegisterEntity = new LeaveRegisterEntity();
		BeanUtils.copyProperties(leaveReqDto, leaveRegisterEntity);
		Date today = new Date(System.currentTimeMillis());

		leaveRegisterEntity.setUpdatedDate(today);
		leaveRegisterEntity.setCreatedDate(Date.valueOf(leaveReqDto.getCreatedDate()));
		leaveRegisterEntity.setStartDate(Date.valueOf(leaveReqDto.getStartDate()));
		leaveRegisterEntity.setEndDate(Date.valueOf(leaveReqDto.getEndDate()));

		leaveRegisterEntity.setStatus(leaveReqDto.getStatus().toString().toLowerCase());
		leaveRegisterEntity.setId(leaveReqDto.getLeaveId());

		return leaveRegisterEntity;
	}

	public List<LeaveRequestDto> fromEntities(List<LeaveRegisterEntity> leaveEntries) {

		return leaveEntries.stream().map(u -> fromEntity(u)).collect(Collectors.toList());

	}

	private void setUserDetails(LeaveRegisterEntity entity, LeaveRequestDto leaveDto) {
		UserEntity userEntity = userJPAPersistence.findByUserId(entity.getUserId());
		leaveDto.setFirstName(userEntity.getFirstName());
		leaveDto.setLastName(userEntity.getFirstName());
	}
}
