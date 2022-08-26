package com.unknown.repository;

import java.util.List;
import java.util.Map;

import com.unknown.entity.AreaEntity;

public interface IAreaRepository {
	public List<AreaEntity> findByBuildingId(Map<String, Object> params, Integer buildingId);

	public String joinCondition(Map<String, Object> params);
}
