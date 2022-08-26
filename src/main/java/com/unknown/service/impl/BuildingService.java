package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.converter.AreaConverter;
import com.unknown.converter.BuildingConverter;
import com.unknown.entity.AreaEntity;
import com.unknown.entity.BuildingEntity;
import com.unknown.model.response.AreaResponse;
import com.unknown.model.response.BuildingResponse;
import com.unknown.model.response.BuildingSearchResponse;
import com.unknown.repository.IBuildingRepository;
import com.unknown.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {
	@Autowired
	private IBuildingRepository buildingRepository;

	@Autowired
	private BuildingConverter buildingConverter;
	@Autowired
	private AreaConverter areaConverter;

	@Override
	public List<BuildingSearchResponse> findAll(Map<String, Object> params, List<String> buildingTypes) {
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, buildingTypes);
		List<BuildingSearchResponse> results = new ArrayList<>();
		for (BuildingEntity item : buildingEntities) {
			// User JDBC
			// BuildingSearchResponse buildingSearchResponse =
			// buildingConverter.convertEntityToSearchResponse(item,params);
			BuildingSearchResponse buildingSearchResponse = new BuildingSearchResponse();
			buildingSearchResponse.setName(item.getName());
			results.add(buildingSearchResponse);
		}
		return results;
	}

	@Override
	public BuildingResponse findById(Integer id) {
		return null;
	}

	@Override
	public List<AreaResponse> findAreaByBuildingId(Integer buildingId) {
		BuildingEntity buildingEntity = buildingRepository.findById(buildingId);
		List<AreaEntity> areaEntities = buildingEntity.getAreaEnties();
		List<AreaResponse> result = new ArrayList<>();
		areaEntities.stream().forEach(item -> result.add(areaConverter.convertEntityToResponse(item)));
		return result;
	}

}
