package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.authorization.UsersBuildingAuthorization;
import com.unknown.converter.AreaConverter;
import com.unknown.converter.BuildingConverter;
import com.unknown.entity.AreaEntity;
import com.unknown.entity.BuildingEntity;
import com.unknown.model.request.BuildingSearchRequest;
import com.unknown.model.request.BuildingUpdateRequest;
import com.unknown.model.request.UsersBuildingRequest;
import com.unknown.model.response.AreaResponse;
import com.unknown.model.response.BuildingSearchResponse;
import com.unknown.model.response.BuildingUpdateResponse;
import com.unknown.repository.BuildingRepository;
import com.unknown.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;

	@Autowired
	private BuildingConverter buildingConverter;

	@Autowired
	private AreaConverter areaConverter;

	@Autowired
	private UsersBuildingAuthorization buiUsersBuildingAuthorization;

	@Override
	public List<BuildingSearchResponse> findBuilding(Map<String, Object> params, List<String> buildingTypes) {
		BuildingSearchRequest buildingSearchRequest = buildingConverter.convertMapToSearchRequest(params,
				buildingTypes);
		/*
		 * List<BuildingEntity> buildingEntities =
		 * buildingRepository.findBuildingCustom(buildingSearchRequest);
		 * List<BuildingSearchResponse> results = new ArrayList<>(); if
		 * (buildingEntities != null) { for (BuildingEntity item : buildingEntities) {
		 * BuildingSearchResponse buildingSearchResponse =
		 * buildingConverter.convertEntityToSearchResponse(item, params);
		 * results.add(buildingSearchResponse); } }
		 */
		List<BuildingSearchResponse> results = findBuilding(buildingSearchRequest);
		return results;
	}

	@Override
	public List<BuildingSearchResponse> findBuilding(BuildingSearchRequest buildingSearchRequest) {
		List<BuildingEntity> buildingEntities = buildingRepository.findBuildingCustom(buildingSearchRequest);
		List<BuildingSearchResponse> results = new ArrayList<>();
		Map<String, Object> params = buildingConverter.convertBuildingSearchRequesToMap(buildingSearchRequest);
		if (buildingEntities != null) {
			for (BuildingEntity item : buildingEntities) {
				BuildingSearchResponse buildingSearchResponse = buildingConverter.convertEntityToSearchResponse(item,
						params);
				results.add(buildingSearchResponse);
			}
		}
		return results;
	}

	@Override
	public BuildingUpdateResponse findById(Integer id) {
		Optional<BuildingEntity> buildingEntity = buildingRepository.findById(id);
		BuildingUpdateResponse result = null;
		if (buildingEntity.isPresent()) {
			result = buildingConverter.convertEntityToUpdateResponse(buildingEntity.get());
		}
		return result;
	}

	@Override
	public List<AreaResponse> findAreaByBuildingId(Integer buildingId) {
		Optional<BuildingEntity> buildingEntity = buildingRepository.findById(buildingId);
		List<AreaEntity> areaEntities = null;
		List<AreaResponse> result = new ArrayList<>();
		if (buildingEntity.isPresent()) {
			areaEntities = buildingEntity.get().getAreaEnties();
			areaEntities.stream().forEach(item -> result.add(areaConverter.convertEntityToResponse(item)));
		}
		return result;
	}

	@Override
	@Transactional
	public BuildingUpdateResponse save(BuildingUpdateRequest updateRequest) {
		BuildingEntity buildingEntity = buildingConverter.convertUpdateRequestToEntity(updateRequest);
		if (updateRequest.getId() != null) {
			buiUsersBuildingAuthorization.checkUsersBuilding(updateRequest.getId());
		}
		BuildingUpdateResponse result = buildingConverter
				.convertEntityToUpdateResponse(buildingRepository.save(buildingEntity));
		return result;
	}

	@Override
	@Transactional
	public void delete(BuildingUpdateRequest updateRequest) {
		if (updateRequest.getId() != null) {
			buiUsersBuildingAuthorization.checkUsersBuilding(updateRequest.getId());
		}
		buildingRepository.deleteById(updateRequest.getId());
	}

	@Override
	@Transactional
	public Integer save(UsersBuildingRequest request) {
		if (request.getBuildingId() != null) {
			buiUsersBuildingAuthorization.checkUsersBuilding(request.getBuildingId());
		}
		BuildingEntity buildingEntity = buildingConverter.convertUsersBuildingRequestToEntity(request);
		buildingRepository.save(buildingEntity);
		return request.getBuildingId();
	}
}
