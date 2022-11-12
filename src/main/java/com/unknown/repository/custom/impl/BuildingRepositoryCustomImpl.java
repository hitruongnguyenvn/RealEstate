package com.unknown.repository.custom.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.unknown.constant.SystemConstant;
import com.unknown.custom.exception.ErrorGeneralException;
import com.unknown.entity.BuildingEntity;
import com.unknown.model.request.AreaSearchRequest;
import com.unknown.model.request.BuildingSearchRequest;
import com.unknown.repository.AreaRepository;
import com.unknown.repository.custom.BuildingRepositoryCustom;
import com.unknown.utils.NumberUtils;
import com.unknown.utils.StringUtils;

@Repository
@Primary
public class BuildingRepositoryCustomImpl implements BuildingRepositoryCustom {

	@Autowired
	AreaRepository areaRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<BuildingEntity> findBuildingCustom(BuildingSearchRequest buildingSearchRequest) {
		StringBuilder nativeSql = new StringBuilder("SELECT * FROM building INNER JOIN");
		nativeSql = this.buildSqlJoining(buildingSearchRequest, nativeSql);
		nativeSql = this.buildSqlCommon(buildingSearchRequest, nativeSql);
		Query nativeQuery = entityManager.createNativeQuery(nativeSql.toString(), BuildingEntity.class);
		return nativeQuery.getResultList();
	}

	private StringBuilder buildSqlJoining(BuildingSearchRequest buildingSearchRequest, StringBuilder sql) {
		String district = buildingSearchRequest.getDistrict();
		Integer usersId = buildingSearchRequest.getUsersId();
		String areaTo = buildingSearchRequest.getAreaTo();
		String areaFrom = buildingSearchRequest.getAreaFrom();
		Float priceTo = buildingSearchRequest.getPriceTo();
		Float priceFrom = buildingSearchRequest.getPriceFrom();
		List<String> buildingTypes = buildingSearchRequest.getBuildingType();
		sql.append(" (SELECT building.id FROM building");
		if (!StringUtils.isNullOrEmpty(district)) {
			sql.append(" INNER JOIN district on building.district_id = district.id");
			sql.append(" AND district.id = " + district + "");
		}
		if (usersId != null) {
			sql.append(" INNER JOIN users_building ON users_building.building_id = building.id");
			sql.append(" AND users_building.users_id = " + usersId + "");
		}
		if (buildingTypes != null) {
			sql.append(" INNER JOIN building_type ON building.building_type_id = building_type.id AND (");
			String join = buildingTypes.stream().map(item -> " building_type.code = '" + item + "'")
					.collect(Collectors.joining(" OR"));
			sql.append(join);
			sql.append(" )");
		}
		if (!StringUtils.isNullOrEmpty(areaTo) || !StringUtils.isNullOrEmpty(areaFrom) || priceFrom != null
				|| priceTo != null) {
			sql.append(" INNER JOIN  area ON building.id = area.building_id");
			AreaSearchRequest areaSearchRequest = new AreaSearchRequest.Builder().setAreaTo(areaTo)
					.setAreaFrom(areaFrom).setPriceTo(priceTo).setPriceFrom(priceFrom).build();
			sql.append(areaRepository.joinCondition(areaSearchRequest));
		}
		sql.append(" " + SystemConstant.ONE_EQUAL_ONE);
		return sql;
	}

	private StringBuilder buildSqlCommon(BuildingSearchRequest buildingSearchRequest, StringBuilder sql) {
		Field[] fields = BuildingSearchRequest.class.getDeclaredFields();
		try {
			for (Field item : fields) {
				item.setAccessible(true);
				String fieldName = item.getName();
				Object objectValue = item.get(buildingSearchRequest);
				if (objectValue != null) {
					if (!fieldName.equals("usersId") && !fieldName.equals("district")
							&& !fieldName.equals("buildingType") && !fieldName.startsWith("area")
							&& !fieldName.startsWith("price")) {
						// Check keys is tyoe number.
						String value = objectValue.toString();
						String key = StringUtils.convertToFieldNameSqlServer(fieldName);
						if (item.getType().getName().equals("java.lang.Integer")) {
							if (NumberUtils.isInteger(value)) {
								sql.append(" AND building." + key + " = " + Integer.parseInt(value) + "");
							}
						} else if (item.getType().getName().equals("java.lang.String")) {
							if (!StringUtils.isNullOrEmpty(value)) {
								sql.append(" AND building." + key + " LIKE '%" + value + "%'");
							}
						}
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ErrorGeneralException(e.getMessage());
		}
		sql.append(" GROUP BY building.id) AS Table1 ON Table1.id = building.id");
		return sql;
	}

	@Override
	public BuildingEntity findByIdCustom(Integer id) {
		String nativeSql = "SELECT * FROM building WHERE building.id = " + id + " ";
		Query nativeQuery = entityManager.createNativeQuery(nativeSql, BuildingEntity.class);
		return (BuildingEntity) nativeQuery.getSingleResult();
	}

	@Override
	public Integer saveCustom(BuildingEntity buildingEntity) {
		if (buildingEntity.getId() != null) {
			entityManager.merge(buildingEntity);
		} else {
			entityManager.persist(buildingEntity);
		}
		return 1;
	}

}
