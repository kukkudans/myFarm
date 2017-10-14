package com.farm.persistence.users;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.farm.persistence.entity.AddressEntity;
import com.farm.rest.dto.UserAddressDto;

@Component
public class UsersAddressTransformer {

	public UserAddressDto fromEntity(AddressEntity addressEntity) {
		UserAddressDto userAddressDto = new UserAddressDto();
		BeanUtils.copyProperties(addressEntity, userAddressDto);
		return userAddressDto;
	}

	public AddressEntity toEntity(UserAddressDto userDto) {
		AddressEntity userAddressEntity = new AddressEntity();
		BeanUtils.copyProperties(userDto, userAddressEntity);
		return userAddressEntity;
	}

}
