package com.farm.persistence.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.persistence.entity.AddressEntity;
import com.farm.persistence.entity.PhoneDetailsEntity;
import com.farm.persistence.entity.UserEntity;
import com.farm.persistence.repository.AddressRepository;
import com.farm.persistence.repository.PhoneRepository;
import com.farm.persistence.repository.UserCredentialRepository;
import com.farm.persistence.repository.UserRepository;

@Component
public class UserJPAPersistence {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserCredentialRepository credentialRepository;

	@Autowired
	private PhoneRepository phoneRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	public void addUser(UserEntity userEntity) {
		 userRepo.save(userEntity);
		phoneRepository.save(userEntity.getPhoneDetails());
	}

	
	public UserEntity updateUser(UserEntity userEntity) {
		return userRepo.save(userEntity);
	}
	
	public void updatePhoneDetails(List<PhoneDetailsEntity> phones) {
		
		phoneRepository.save(phones);
	}

	public UserEntity findByFirstNameAndLastName(String firstName, String lastName) {
		return userRepo.findByFirstNameAndLastName(firstName, lastName);
	}

	public UserEntity findByUserId(String userId) {
		return userRepo.findByUserId(userId);
	}

	public void deleteUser(UserEntity userEntity) {
		userRepo.delete(userEntity);
	}

	public List<UserEntity> findAll() {
		return (List<UserEntity>) userRepo.findAll();
	}

	public UserEntity authenticate(String userId, String password) {
		return credentialRepository.authenticate(userId, password);
	}
	public AddressEntity findAddressByUserId(String userId) {
		return addressRepository.findByUserId(userId);
	}

	public void deletePhones(UserEntity userEntity) {
		userEntity.getPhoneDetails().forEach(phoneRepository::delete);
		
	}

	public void saveAddress(AddressEntity addressEntity) {
		addressRepository.save(addressEntity);
	}
}
