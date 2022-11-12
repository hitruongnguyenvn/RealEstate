package com.unknown.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.unknown.constant.SystemConstant;
import com.unknown.entity.AreaEntity;
import com.unknown.model.request.AreaSearchRequest;
import com.unknown.repository.custom.AreaRepositoryCustom;
import com.unknown.utils.StringUtils;

@Repository
@Primary
public class AreaRepositoryCustomImpl implements AreaRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<AreaEntity> findByBuildingIdCustom(Integer buildingId, Integer status,
			AreaSearchRequest areaSearchRequest) {
		StringBuilder nativeSql = new StringBuilder("SELECT * FROM area " + SystemConstant.ONE_EQUAL_ONE + "");
		if (status != null) {
			nativeSql.append(" AND status=" + status);
		}
		nativeSql.append(this.joinCondition(areaSearchRequest));
		nativeSql.append(" AND building_id = " + buildingId + " ORDER BY area.floor ASC ");
		Query nativeQuery = entityManager.createNativeQuery(nativeSql.toString(), AreaEntity.class);
		return nativeQuery.getResultList();
	}

	@Override
	public String joinCondition(AreaSearchRequest areaSearchRequest) {
		StringBuilder sql = new StringBuilder(" ");
		if (areaSearchRequest == null) {
			return " ";
		}
		String areaTo = areaSearchRequest.getAreaTo();
		String areaFrom = areaSearchRequest.getAreaFrom();
		Float priceFrom = areaSearchRequest.getPriceFrom();
		Float priceTo = areaSearchRequest.getPriceTo();
		if (!StringUtils.isNullOrEmpty(areaTo)) {
			sql.append(" AND (area.area >= " + areaTo + "");
		}
		if (!StringUtils.isNullOrEmpty(areaFrom)) {
			sql.append(" AND area.area <= " + areaFrom + "");
		}
		if (!StringUtils.isNullOrEmpty(areaTo)) {
			sql.append(")");
		}
		if (priceTo != null) {
			sql.append(" AND (area.price >= " + priceTo + "");
		}
		if (priceFrom != null) {
			sql.append(" AND area.price <= " + priceFrom + "");
		}
		if (priceTo != null) {
			sql.append(")");
		}
		return sql.toString();
	}

}
