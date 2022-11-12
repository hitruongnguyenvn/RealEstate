package com.unknown.converter;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.entity.AreaEntity;
import com.unknown.entity.BuildingEntity;
import com.unknown.model.request.AreaSearchRequest;
import com.unknown.model.request.AreaUpdateRequest;
import com.unknown.model.response.AreaResponse;
import com.unknown.repository.AreaRepository;
import com.unknown.utils.MapUtils;

@Component
public class AreaConverter {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AreaRepository areaRepository;

	public AreaResponse convertEntityToResponse(AreaEntity entity) {
		AreaResponse areaResponse = modelMapper.map(entity, AreaResponse.class);
		areaResponse.setBuildingName(entity.getBuildingEntity().getName());
		areaResponse.setBuildingId(entity.getBuildingEntity().getId());
		String value = entity.getStatus() == 1 ? "Đã thuê" : "Trống";
		areaResponse.setStatusString(value);
		return areaResponse;
	}

	public AreaSearchRequest convertMapToSearchRequest(Map<String, Object> params) {
		AreaSearchRequest areaResponse = new AreaSearchRequest.Builder()
				.setAreaTo(MapUtils.getValue(params, "areaTo", String.class))
				.setAreaFrom(MapUtils.getValue(params, "areaFrom", String.class))
				.setPriceTo(MapUtils.getValue(params, "priceTo", Float.class))
				.setPriceFrom(MapUtils.getValue(params, "priceFrom", Float.class)).build();
		return areaResponse;
	}

	public AreaEntity convertUpdateRequestToEntity(AreaUpdateRequest updateRequest) {
		AreaEntity result = null;
		if (updateRequest.getId() != null) {
			result = areaRepository.getOne(updateRequest.getId());
		} else {
			result = new AreaEntity();
		}
		result.setArea(updateRequest.getArea());
		result.setFloor(updateRequest.getFloor());
		result.setPrice(updateRequest.getPrice());
		result.setStatus(updateRequest.getStatus());
		BuildingEntity buildingEntity = new BuildingEntity();
		buildingEntity.setId(updateRequest.getBuildingId());
		result.setBuildingEntity(buildingEntity);
		return result;
	}
}
