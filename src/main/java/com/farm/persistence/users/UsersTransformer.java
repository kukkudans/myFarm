package com.farm.persistence.users;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.persistence.entity.PhoneDetailsEntity;
import com.farm.persistence.entity.UserEntity;
import com.farm.rest.dto.UserDto;

@Component
public class UsersTransformer {

	@Autowired
	private PhoneDetailTransformer phoneDetailTransformer;

	public UserDto fromEntity(UserEntity user) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		userDto.setDob(user.getDob().toString());
		userDto.setCreatedDate(user.getCreatedDate().toString());
		List<String> phoneNumberList = phoneDetailTransformer.fromEntity(user.getPhoneDetails());
		userDto.setMobiles(phoneNumberList);
		return userDto;
	}

	public UserEntity toEntity(UserDto userDto) {
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(userDto, user);
		user.setDob(Date.valueOf(userDto.getDob()));
		Date createdDate = StringUtils.isEmpty(userDto.getCreatedDate())
				? new Date(Calendar.getInstance().getTimeInMillis()) : Date.valueOf(userDto.getCreatedDate());
		user.setCreatedDate(createdDate);
		List<PhoneDetailsEntity> phoneDetails = phoneDetailTransformer.toEntity(userDto.getMobiles(), user);

		user.setPhoneDetails(phoneDetails);
		return user;
	}

	public List<UserDto> fromEntities(List<UserEntity> userEntities) {

		return userEntities.stream().map(u -> fromEntity(u)).collect(Collectors.toList());

	}

}
