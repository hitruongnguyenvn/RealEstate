package com.unknown.repository;

import java.util.List;
import java.util.Map;

import com.unknown.entity.BuildingEntity;

public interface IBuildingRepository {
	public List<BuildingEntity> findAll(Map<String, String> params, List<String> buildingTypes);
}
