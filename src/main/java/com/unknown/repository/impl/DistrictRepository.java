package com.unknown.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.unknown.entity.DistrictEntity;
import com.unknown.mapper.DistrictMapper;
import com.unknown.repository.IDistrictRepository;

@Repository
public class DistrictRepository implements IDistrictRepository {

	@Override
	public DistrictEntity findById(Integer id) {
		String sql = "SELECT * FROM District WHERE District.id = "+id+"";
		List<DistrictEntity> districtEntities = DataProvider.getInstance().executeQuery(sql, new DistrictMapper(), null);
		return (districtEntities.size() > 0) ? districtEntities.get(0) : null;
	}

}
