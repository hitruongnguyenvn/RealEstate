package com.unknown.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.unknown.entity.CityEntity;

public class CityMapper implements IRowMapper<CityEntity> {

	@Override
	public CityEntity mapRow(ResultSet resultSet) {
		CityEntity cityEntity = new CityEntity();
		try {
			cityEntity.setId(resultSet.getInt("id"));
			cityEntity.setName(resultSet.getNString("name"));
			cityEntity.setCode(resultSet.getString("code"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cityEntity;
	}

}
