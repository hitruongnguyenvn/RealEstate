package com.unknown.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.unknown.entity.DistrictEntity;

public class DistrictMapper implements IRowMapper<DistrictEntity> {
	@Override
	public DistrictEntity mapRow(ResultSet resultSet) {
		DistrictEntity districtEntity = new DistrictEntity();
		try {
			districtEntity.setId(resultSet.getInt("id"));
			districtEntity.setName(resultSet.getNString("name"));
			districtEntity.setCode(resultSet.getString("code"));
			districtEntity.setCityId(resultSet.getInt("cityId"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return districtEntity;
	}
}
