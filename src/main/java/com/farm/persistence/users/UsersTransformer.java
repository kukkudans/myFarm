package com.farm.persistence.users;

import java.util.List;
import java.util.stream.Collectors;

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
		List<String> phoneNumberList = phoneDetailTransformer.fromEntity(user.getPhoneDetails());
		userDto.setMobiles(phoneNumberList);
		return userDto;
	}

	public UserEntity toEntity(UserDto userDto) {
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(userDto, user);
		List<PhoneDetailsEntity> phoneDetails = phoneDetailTransformer.toEntity(userDto.getMobiles(), user);
		
		user.setPhoneDetails(phoneDetails);
		return user;
	}

	public List<UserDto> fromEntities(List<UserEntity> userEntities) {

		return userEntities.stream().map(u -> fromEntity(u)).collect(Collectors.toList());

	}

}
