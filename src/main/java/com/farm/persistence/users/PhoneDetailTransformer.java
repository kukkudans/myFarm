package com.farm.persistence.users;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.farm.persistence.entity.PhoneDetailsEntity;
import com.farm.persistence.entity.UserEntity;

@Component
public class PhoneDetailTransformer {

	public List<String> fromEntity(List<PhoneDetailsEntity> phoneEntityList) {
		return phoneEntityList.stream().map(p -> p.getNumber()).collect(Collectors.toList());
	}

	public List<PhoneDetailsEntity> toEntity(List<String> phoneList, UserEntity userEntity) {
		return phoneList.stream().map(m -> new PhoneDetailsEntity(m, userEntity)).collect(Collectors.toList());
	}
}
