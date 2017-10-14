package com.farm.persistence.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.farm.persistence.entity.FarmTypeEntity;
import com.farm.persistence.repository.FarmTypeRepository;

@Component
public class FarmTypeJPAPersistence {

	@Autowired
	private FarmTypeRepository farmTypeRepo;

	public List<FarmTypeEntity> getFarmTypes() {
		return (List<FarmTypeEntity>) farmTypeRepo.findAll();
	}
}
