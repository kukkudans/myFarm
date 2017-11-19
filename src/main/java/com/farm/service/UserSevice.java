package com.farm.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.exception.FarmAppException;
import com.farm.persistence.entity.AddressEntity;
import com.farm.persistence.entity.UserEntity;
import com.farm.persistence.users.UsersAddressTransformer;
import com.farm.persistence.users.UsersTransformer;
import com.farm.persistence.util.UserJPAPersistence;
import com.farm.rest.dto.UserAddressDto;
import com.farm.rest.dto.UserDto;

@Component
public class UserSevice {

	@Autowired
	private UserJPAPersistence userJPAPersistence;

	@Autowired
	private UsersTransformer transformer;

	@Autowired
	private UsersAddressTransformer addressTransformer;

	public List<UserDto> getUsers() {
		List<UserEntity> userEntities = (List<UserEntity>) userJPAPersistence.findAll();
		return transformer.fromEntities(userEntities);
	}

	public void addUser(UserDto user) throws FarmAppException {
		UserEntity userEntity = userJPAPersistence.findByUserId(user.getUserId());
		if (null == userEntity) {
			userEntity = transformer.toEntity(user);
			userJPAPersistence.addUser(userEntity);
			return;
		}

		throw new FarmAppException("user already added");
	}

	public void deleteUser(String userId) {
		UserEntity userEntity = userJPAPersistence.findByUserId(userId);
		userJPAPersistence.deleteUser(userEntity);
	}

	@Transactional
	public void updateUser(UserDto user) {
		UserEntity userEntity = userJPAPersistence.findByUserId(user.getUserId());
		if (null == userEntity) {
			throw new NotFoundException("user not found");
		}
		userJPAPersistence.deletePhones(userEntity);

		UserEntity trasnformedEntity = transformer.toEntity(user);
		BeanUtils.copyProperties(trasnformedEntity, userEntity, "id");

		trasnformedEntity.getPhoneDetails().stream().forEach(e -> e.setUser(userEntity));
		userJPAPersistence.updatePhoneDetails(trasnformedEntity.getPhoneDetails());
		userJPAPersistence.updateUser(userEntity);
	}

	public UserDto getUser(String userId) {
		UserEntity userEntity = userJPAPersistence.findByUserId(userId);
		if (null == userEntity) {
			throw new NotFoundException("user not found");
		}

		return transformer.fromEntity(userEntity);
	}

	public UserAddressDto getUserAddress(String userId) {
		AddressEntity addressEntity = userJPAPersistence.findAddressByUserId(userId);
		if (null == addressEntity) {
			throw new NotFoundException("user not found");
		}

		return addressTransformer.fromEntity(addressEntity);
	}

	public UserAddressDto updateUserAddress(String userId, UserAddressDto addressDto) {
		AddressEntity addressEntity = userJPAPersistence.findAddressByUserId(userId);
		if (null == addressEntity) {
			throw new NotFoundException("user not found");
		}

		AddressEntity newAddress = addressTransformer.toEntity(addressDto);
		BeanUtils.copyProperties(newAddress, addressEntity, "id", "user");
		userJPAPersistence.saveAddress(addressEntity);

		return addressTransformer.fromEntity(addressEntity);
	}

	public boolean isUserPresent(String userId) {
		UserEntity userEntity = userJPAPersistence.findByUserId(userId);

		if (null == userEntity) {
			return false;
		}
		return true;
	}

	public UserAddressDto addUserAddress(String userId, UserAddressDto addressDto) {
		AddressEntity addressEntity = addressTransformer.toEntity(addressDto);
		addressEntity.setUser(userId);
		userJPAPersistence.saveAddress(addressEntity);

		return addressDto;
	}
}
