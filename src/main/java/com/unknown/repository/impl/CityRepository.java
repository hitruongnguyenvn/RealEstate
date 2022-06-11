package com.unknown.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unknown.entity.CityEntity;
import com.unknown.mapper.CityMapper;
import com.unknown.repository.ICityRepository;

@Repository
public class CityRepository implements ICityRepository {

	@Override
	public CityEntity findById(Integer id) {
		String sql = "SELECT * FROM City WHERE City.id = " + id + "";
		List<CityEntity> cityEntities = DataProvider.getInstance().executeQuery(sql, new CityMapper(), null);
		return (cityEntities.size() > 0) ? cityEntities.get(0) : null;
	}

}
