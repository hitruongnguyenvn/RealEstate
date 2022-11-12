package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.authorization.UsersBuildingAuthorization;
import com.unknown.converter.AreaConverter;
import com.unknown.entity.AreaEntity;
import com.unknown.model.request.AreaUpdateRequest;
import com.unknown.model.response.AreaResponse;
import com.unknown.repository.AreaRepository;
import com.unknown.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaRepository areaRepository;

	@Autowired
	private UsersBuildingAuthorization usersBuildingAuthorization;

	@Autowired
	private AreaConverter areaConverter;

	@Override
	public List<AreaResponse> findByBuildingId(Integer buildingId, Integer status) {
		List<AreaEntity> areaEntities = areaRepository.findByBuildingIdCustom(buildingId, status, null);
		List<AreaResponse> result = new ArrayList<>();
		areaEntities.stream().forEach(item -> result.add(areaConverter.convertEntityToResponse(item)));
		return result;
	}

	@Override
	@Transactional
	public AreaResponse save(AreaUpdateRequest updateRequest) {
		if (updateRequest.getBuildingId() != null) {
			usersBuildingAuthorization.checkUsersBuilding(updateRequest.getBuildingId());
		}
		AreaEntity areaEntity = areaConverter.convertUpdateRequestToEntity(updateRequest);
		AreaResponse result = areaConverter.convertEntityToResponse(areaRepository.save(areaEntity));
		return result;
	}

	@Override
	@Transactional
	public void delete(AreaUpdateRequest updateRequest) {
		if (updateRequest.getBuildingId() != null) {
			usersBuildingAuthorization.checkUsersBuilding(updateRequest.getBuildingId());
		}
		areaRepository.deleteById(updateRequest.getId());
	}

	@Override
	@Transactional
	public void updateStatusById(Integer id) {
		AreaEntity areaEntity = areaRepository.findById(id).get();
		areaEntity.setStatus(1);
		areaRepository.save(areaEntity);
	}
}
