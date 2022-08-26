package com.unknown.repository;

import java.util.List;
import java.util.Map;

import com.unknown.entity.BuildingEntity;

public interface IBuildingJDBC {
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> buildingTypes);

	public BuildingEntity findById(Integer id);
}
