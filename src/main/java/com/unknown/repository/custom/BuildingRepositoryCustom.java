package com.unknown.repository.custom;

import java.util.List;

import com.unknown.entity.BuildingEntity;
import com.unknown.model.request.BuildingSearchRequest;

public interface BuildingRepositoryCustom {

	public List<BuildingEntity> findBuildingCustom(BuildingSearchRequest buildingSearchRequest);

	public BuildingEntity findByIdCustom(Integer id);

	public Integer saveCustom(BuildingEntity buildingEntity);
}
