package com.unknown.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.unknown.entity.AreaEntity;
import com.unknown.mapper.AreaMapper;
import com.unknown.repository.IAreaRepository;
import com.unknown.utils.StringUtils;

@Repository
public class AreaRepository implements IAreaRepository {

	@Override
	public List<AreaEntity> findByBuildingId(Map<String, String> params, Integer buildingId) {
		List<AreaEntity> areaEntities = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM Area WHERE 1=1 ");
		sql.append(this.joinCondition(params));
		sql.append("AND buildingId = " + buildingId + " ORDER BY Area.floor ASC ");
		areaEntities = DataProvider.getInstance().executeQuery(sql.toString(), new AreaMapper(), null);
		return areaEntities;
	}

	@Override
	public String joinCondition(Map<String, String> params) {
		StringBuilder sql = new StringBuilder();
		if(params == null) {
			return "";
		}
		String areaTo = params.get("areaTo");
		String areaFrom = params.get("areaFrom");
		String priceFrom = params.get("priceFrom");
		String priceTo = params.get("priceTo");
		if (!StringUtils.isNullOrEmpty(areaTo)) {
			sql.append("AND (Area.area >= " + areaTo + " ");
			if (!StringUtils.isNullOrEmpty(areaFrom)) {
				sql.append("AND Area.area <= " + areaFrom + ") ");
			} else {
				sql.append(") ");
			}
		}
		if (!StringUtils.isNullOrEmpty(priceTo)) {
			sql.append("AND (Area.price >= " + priceTo + " ");
			if (!StringUtils.isNullOrEmpty(priceFrom)) {
				sql.append("AND Area.price <= " + priceFrom + ") ");
			} else {
				sql.append(") ");
			}
		}
		return sql.toString();
	}

}
