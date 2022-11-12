package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.converter.BuildingTypeConverter;
import com.unknown.entity.BuildingTypeEntity;
import com.unknown.model.response.BuildingTypeResponse;
import com.unknown.repository.BuildingTypeRepository;
import com.unknown.service.BuildingTypeService;

@Service
public class BuildingTypeServiceImpl implements BuildingTypeService {

	@Autowired
	private BuildingTypeRepository buildingTypeRepository;

	@Autowired
	private BuildingTypeConverter buildingTypeConverter;

	@Override
	public List<BuildingTypeResponse> findAll() {
		List<BuildingTypeEntity> buildingTypeEntities = buildingTypeRepository.findAll();
		List<BuildingTypeResponse> result = new ArrayList<BuildingTypeResponse>();
		buildingTypeEntities.stream().forEach(item -> result.add(buildingTypeConverter.convertEntityToResponse(item)));
		return result;
	}

}
