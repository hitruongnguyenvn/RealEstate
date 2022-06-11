package com.unknown.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.unknown.entity.BuildingEntity;
import com.unknown.mapper.BuildingMapper;
import com.unknown.repository.IAreaRepository;
import com.unknown.repository.IBuildingRepository;
import com.unknown.utils.StringUtils;

@Repository
public class BuildingRepository implements IBuildingRepository {
	@Autowired
	IAreaRepository areaRepository;
	@Autowired
	DataProviderRepository dataProviderRepository;
	@Override
	public List<BuildingEntity> findAll(Map<String, String> params, List<String> buildingTypes) {
		List<BuildingEntity> results = new ArrayList<>();
		StringBuilder sql = joinTable(params, buildingTypes);
		sql.append(joinCondition(params));
		//results = DataProvider.getInstance().executeQuery(sql.toString(), new BuildingMapper(), null);
		results = dataProviderRepository.executeQuery(sql.toString(), new BuildingMapper(), null);
		return results;
	}

	private StringBuilder joinTable(Map<String, String> params, List<String> buildingTypes) {
		StringBuilder sql = new StringBuilder("SELECT * FROM Building INNER JOIN ");
		sql.append("(SELECT Building.id FROM Building ");
		sql.append("INNER JOIN District on Building.districtId = District.id ");
		String district = params.get("district");
		String usersId = params.get("usersId");
		String areaTo = params.get("areaTo");
		String areaFrom = params.get("areaFrom");
		String priceFrom = params.get("priceFrom");
		String priceTo = params.get("priceTo");
		if (!StringUtils.isNullOrEmpty(district)) {
			sql.append("AND District.code = '" + district + "' ");
		}

		if (!StringUtils.isNullOrEmpty(usersId)) {
			sql.append("INNER JOIN UsersBuilding ON UsersBuilding.buildingId = Building.id ");
			sql.append("AND UsersBuilding.usersId = " + usersId + " ");
		}
		
		if (buildingTypes != null && buildingTypes.size() > 0) {
			sql.append("INNER JOIN BuildingType ON Building.buildingTypeId = BuildingType.id AND ( ");
			int size = buildingTypes.size();
			for (int i = 0; i < size; ++i) {
				sql.append("BuildingType.code = '"+ buildingTypes.get(i) +"' OR ");
			}
			sql.append("1=2) ");
		}
		if(!StringUtils.isNullOrEmpty(areaTo) || !StringUtils.isNullOrEmpty(areaFrom)
				|| !StringUtils.isNullOrEmpty(priceFrom) || !StringUtils.isNullOrEmpty(priceTo)) {
			sql.append("INNER JOIN  Area ON Building.id = Area.buildingId ");
			sql.append(areaRepository.joinCondition(params));
		}
		sql.append("WHERE 1=1 ");
		return sql;
	}

	private StringBuilder joinCondition(Map<String, String> params) {
		StringBuilder sql = new StringBuilder();
		String name = params.get("name");
		String ward = params.get("ward");
		String street = params.get("street");
		String numberOfBasement = params.get("numberOfBasement");
		String directions = params.get("directions");
		String level = params.get("level");
		String managerName = params.get("managerName");
		String managerPhoneNumber = params.get("managerPhoneNumber");
		if (!StringUtils.isNullOrEmpty(name)) {
			sql.append("AND Building.name LIKE %" + name + "% ");
		}
		if (!StringUtils.isNullOrEmpty(ward)) {
			sql.append("AND Building.ward LIKE %" + ward + "% ");
		}
		if (!StringUtils.isNullOrEmpty(street)) {
			sql.append("AND Building.street LIKE %" + street + "% ");
		}

		if (!StringUtils.isNullOrEmpty(numberOfBasement)) {
			sql.append("AND Building.numberOfBasement = " + numberOfBasement + " ");
		}
		if (!StringUtils.isNullOrEmpty(directions)) {
			sql.append("AND Building.directions LIKE %" + directions + "% ");
		}
		if (!StringUtils.isNullOrEmpty(level)) {
			sql.append("AND Building.level LIKE %" + level + "% ");
		}
		if (!StringUtils.isNullOrEmpty(managerName)) {
			sql.append("AND Building.managerName LIKE %" + managerName + "% ");
		}
		if (!StringUtils.isNullOrEmpty(managerPhoneNumber)) {
			sql.append("AND Building.managerPhoneNumber LIKE %" + managerPhoneNumber + "% ");
		}
		sql.append(" GROUP BY Building.id) AS Table1 ON Table1.id = Building.id");
		return sql;
	}
}
