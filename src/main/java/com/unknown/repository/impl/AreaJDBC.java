package com.unknown.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.unknown.constant.SystemConstant;
import com.unknown.entity.AreaEntity;
import com.unknown.mapper.AreaMapper;
import com.unknown.repository.IAreaRepository;
import com.unknown.utils.MapUtils;
import com.unknown.utils.StringUtils;

@Repository
public class AreaJDBC implements IAreaRepository {

	@Override
	public List<AreaEntity> findByBuildingId(Map<String, Object> params, Integer buildingId) {
		List<AreaEntity> areaEntities = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM Area " + SystemConstant.ONE_EQUAL_ONE + "");
		sql.append(this.joinCondition(params));
		sql.append(" AND buildingId = " + buildingId + " ORDER BY Area.floor ASC ");
		areaEntities = DataProvider.getInstance().executeQuery(sql.toString(), new AreaMapper(), null);
		return areaEntities;
	}

	@Override
	public String joinCondition(Map<String, Object> params) {
		StringBuilder sql = new StringBuilder(" ");
		if (params == null) {
			return " ";
		}
		String areaTo = MapUtils.getValue(params, "areaTo", String.class);
		String areaFrom = MapUtils.getValue(params, "areaFrom", String.class);
		Float priceFrom = MapUtils.getValue(params, "priceFrom", Float.class);
		Float priceTo = MapUtils.getValue(params, "priceTo", Float.class);
		if (!StringUtils.isNullOrEmpty(areaTo)) {
			sql.append(" AND (Area.area >= " + areaTo + "");
		}
		if (!StringUtils.isNullOrEmpty(areaFrom)) {
			sql.append(" AND Area.area <= " + areaFrom + "");
		}
		if (!StringUtils.isNullOrEmpty(areaTo)) {
			sql.append(")");
		}
		if (priceTo != null) {
			sql.append(" AND (Area.price >= " + priceTo + "");
		}
		if (priceFrom != null) {
			sql.append(" AND Area.price <= " + priceFrom + "");
		}
		if (priceTo != null) {
			sql.append(")");
		}
		return sql.toString();
	}

}
