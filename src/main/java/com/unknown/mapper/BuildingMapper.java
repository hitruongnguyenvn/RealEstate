package com.unknown.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.unknown.entity.BuildingEntity;
import com.unknown.entity.BuildingTypeEntity;
import com.unknown.entity.DistrictEntity;

public class BuildingMapper implements IRowMapper<BuildingEntity> {

	@Override
	public BuildingEntity mapRow(ResultSet resultSet) {
		BuildingEntity buildingEntity = new BuildingEntity();
		try {
			buildingEntity.setId(resultSet.getInt("id"));
			buildingEntity.setName(resultSet.getNString("name"));
			buildingEntity.setWard(resultSet.getNString("ward"));
			buildingEntity.setStreet(resultSet.getNString("street"));
			buildingEntity.setNumberOfBasement(resultSet.getInt("numberOfBasement"));
			buildingEntity.setDiscribe(resultSet.getString("discribe"));
			buildingEntity.setStatus(resultSet.getInt("status"));
			buildingEntity.setManagerName(resultSet.getNString("managerName"));
			buildingEntity.setManagerPhoneNumber(resultSet.getNString("managerPhoneNumber"));
			buildingEntity.setDistrictEntity(new DistrictEntity());
			buildingEntity.getDistrictEntity().setId(resultSet.getInt("districtId"));
			buildingEntity.setBuildingTypeEntity(new BuildingTypeEntity());
			buildingEntity.getBuildingTypeEntity().setId(resultSet.getInt("buildingTypeId"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return buildingEntity;
	}

}
