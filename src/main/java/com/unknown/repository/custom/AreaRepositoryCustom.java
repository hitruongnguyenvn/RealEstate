package com.unknown.repository.custom;

import java.util.List;

import com.unknown.entity.AreaEntity;
import com.unknown.model.request.AreaSearchRequest;

public interface AreaRepositoryCustom {
	public List<AreaEntity> findByBuildingIdCustom(Integer buildingId, Integer status,
			AreaSearchRequest areaSearchRequest);

	public String joinCondition(AreaSearchRequest areaSearchRequest);
}
