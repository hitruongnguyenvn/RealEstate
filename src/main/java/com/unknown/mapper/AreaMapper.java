package com.unknown.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.unknown.entity.AreaEntity;
import com.unknown.entity.BuildingEntity;

public class AreaMapper implements IRowMapper<AreaEntity> {

	@Override
	public AreaEntity mapRow(ResultSet resultSet) {
		AreaEntity areaEntity = new AreaEntity();
		try {
			areaEntity.setArea(resultSet.getString("area"));
			areaEntity.setFloor(resultSet.getInt("floor"));
			areaEntity.setBuildingEntity(new BuildingEntity());
			areaEntity.getBuildingEntity().setId(resultSet.getInt("buildingId"));
			areaEntity.setPrice(resultSet.getDouble("price"));
			areaEntity.setStatus(resultSet.getInt("status"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areaEntity;
	}

}
