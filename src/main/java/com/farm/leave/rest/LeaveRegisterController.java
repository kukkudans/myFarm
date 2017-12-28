package com.farm.leave.rest;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.exception.FarmAppException;
import com.farm.rest.dto.LeaveRequestDto;
import com.farm.rest.dto.LeaveRequestDto.LeaveStatus;
import com.farm.rest.dto.response.FarmBaseResponse;
import com.farm.service.LeaveRegisterSevice;

@RestController
public class LeaveRegisterController {

	@Autowired
	private LeaveRegisterSevice leaveRegisterSevice;

	@RequestMapping(value = "/user/{userId}/leaveentries", method = RequestMethod.GET)
	public ResponseEntity<FarmBaseResponse<List<LeaveRequestDto>>> getLeaveEntries(
			@PathVariable("userId") String userId) {
		List<LeaveRequestDto> leaves = leaveRegisterSevice.getLeaveEntries(userId);

		return new ResponseEntity<FarmBaseResponse<List<LeaveRequestDto>>>(new FarmBaseResponse<>(leaves),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{userId}/leave/from/{startDate}", method = RequestMethod.GET)
	public ResponseEntity<FarmBaseResponse<List<LeaveRequestDto>>> getLeaveEntries(
			@PathVariable("userId") String userId, @PathVariable("startDate") Date startDate) {
		List<LeaveRequestDto> leaves;

		leaves = leaveRegisterSevice.getLeaveEntries(userId, startDate);

		return new ResponseEntity<FarmBaseResponse<List<LeaveRequestDto>>>(new FarmBaseResponse<>(leaves),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{userId}/leaveentries", method = RequestMethod.POST)
	public ResponseEntity<FarmBaseResponse<LeaveRequestDto>> addLeaveEntry(@PathVariable("userId") String userId,
			@RequestBody LeaveRequestDto leaveRequest) {
		leaveRequest.setUserId(userId);
		LeaveRequestDto leave = null;
		try {
			leave = leaveRegisterSevice.addLeaveEntry(leaveRequest);
		} catch (FarmAppException e) {
			return new ResponseEntity<FarmBaseResponse<LeaveRequestDto>>(new FarmBaseResponse<>(e.getMessage()),
					HttpStatus.CONFLICT);
		}
		return new ResponseEntity<FarmBaseResponse<LeaveRequestDto>>(new FarmBaseResponse<>(leave), HttpStatus.OK);
	}

	@RequestMapping(value = "/user/{userId}/leaveentries", method = RequestMethod.PUT)
	public ResponseEntity<FarmBaseResponse<LeaveRequestDto>> updateLeaveEntry(@PathVariable("userId") String userId,
			@RequestBody LeaveRequestDto leaveRequest) {
		leaveRequest.setUserId(userId);
		LeaveRequestDto leave = null;
		leave = leaveRegisterSevice.updateLeaveEntry(leaveRequest);

		return new ResponseEntity<FarmBaseResponse<LeaveRequestDto>>(new FarmBaseResponse<>(leave), HttpStatus.OK);
	}

	@RequestMapping(value = "/leave/{leaveId}/status/{status}", method = RequestMethod.PUT)
	public ResponseEntity<FarmBaseResponse<LeaveRequestDto>> updateLeaveStatus(@PathVariable("leaveId") Long leaveId,
			@PathVariable("status") LeaveStatus status) {
		LeaveRequestDto leave = leaveRegisterSevice.updateLeaveStatus(leaveId, status);

		return new ResponseEntity<FarmBaseResponse<LeaveRequestDto>>(new FarmBaseResponse<>(leave), HttpStatus.OK);
	}

}