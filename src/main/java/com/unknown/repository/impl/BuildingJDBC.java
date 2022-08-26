package com.unknown.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.unknown.constant.SystemConstant;
import com.unknown.entity.BuildingEntity;
import com.unknown.mapper.BuildingMapper;
import com.unknown.repository.IAreaRepository;
import com.unknown.repository.IBuildingRepository;
import com.unknown.utils.MapUtils;
import com.unknown.utils.NumberUtils;
import com.unknown.utils.StringUtils;

@Repository
public class BuildingJDBC implements IBuildingRepository {
	@Autowired
	IAreaRepository areaRepository;
	@Autowired
	DataProviderRepository dataProviderRepository;

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> buildingTypes) {
		List<BuildingEntity> results = new ArrayList<>();
		StringBuilder sql = new StringBuilder("SELECT * FROM Building INNER JOIN");
		sql = this.buildSqlJoining(params, buildingTypes, sql);
		sql = this.buildSqlCommon(params, buildingTypes, sql);
		sql = this.buildSqlSpecial(params, buildingTypes, sql);
		results = DataProvider.getInstance().executeQuery(sql.toString(), new BuildingMapper(), null);
		// results = dataProviderRepository.executeQuery(sql.toString(), new
		// BuildingMapper(), null);
		return results;
	}

	private StringBuilder buildSqlJoining(Map<String, Object> params, List<String> buildingTypes, StringBuilder sql) {
		String district = MapUtils.getValue(params, "district", String.class);
		Integer usersId = MapUtils.getValue(params, "usersId", Integer.class);
		String areaTo = MapUtils.getValue(params, "areaTo", String.class);
		String areaFrom = MapUtils.getValue(params, "areaFrom", String.class);
		Float priceTo = MapUtils.getValue(params, "priceTo", Float.class);
		Float priceFrom = MapUtils.getValue(params, "priceFrom", Float.class);
		sql.append(" (SELECT Building.id FROM Building");
		sql.append(" INNER JOIN District on Building.districtId = District.id");
		if (!StringUtils.isNullOrEmpty(district)) {
			sql.append(" AND District.code = '" + district + "'");
		}
		if (usersId != null) {
			sql.append(" INNER JOIN UsersBuilding ON UsersBuilding.buildingId = Building.id");
			sql.append(" AND UsersBuilding.usersId = " + usersId + "");
		}
		if (buildingTypes != null) {
			sql.append(" INNER JOIN BuildingType ON Building.buildingTypeId = BuildingType.id AND (");
			String join = buildingTypes.stream().map(item -> " BuildingType.code = '" + item + "'")
					.collect(Collectors.joining(" OR"));
			sql.append(join);
			sql.append(" )");
		}
		if (!StringUtils.isNullOrEmpty(areaTo) || !StringUtils.isNullOrEmpty(areaFrom) || priceFrom != null
				|| priceTo != null) {
			sql.append(" INNER JOIN  Area ON Building.id = Area.buildingId");
			sql.append(areaRepository.joinCondition(params));
		}
		sql.append(" " + SystemConstant.ONE_EQUAL_ONE);
		return sql;
	}

	private StringBuilder buildSqlCommon(Map<String, Object> params, List<String> buildingTypes, StringBuilder sql) {
		for (Map.Entry<String, Object> item : params.entrySet()) {
			String key = item.getKey();
			String value = item.getValue().toString();
			if (!key.equals("usersId") && !key.equals("district") && !key.equals("buildingType")
					&& !key.startsWith("area") && !key.startsWith("price")) {
				// Check keys is tyoe number.
				if (key.equals("numberOfBasement")) {
					if (NumberUtils.isInteger(value)) {
						sql.append(" AND Building." + key + " = " + Integer.parseInt(value) + "");
					}
				} else {
					if (!StringUtils.isNullOrEmpty(value)) {
						sql.append(" AND Building." + key + " LIKE '%" + value + "%'");
					}
				}
			}
		}
		sql.append(" GROUP BY Building.id) AS Table1 ON Table1.id = Building.id");
		return sql;
	}

	private StringBuilder buildSqlSpecial(Map<String, Object> params, List<String> buildingTypes, StringBuilder sql) {
		return sql;
	}

	@Override
	public BuildingEntity findById(Integer id) {
		return null;
	}
}
