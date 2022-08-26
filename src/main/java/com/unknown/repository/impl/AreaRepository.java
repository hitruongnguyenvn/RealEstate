package com.unknown.repository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.unknown.entity.AreaEntity;
import com.unknown.repository.IAreaRepository;

@Repository
@Primary
public class AreaRepository implements IAreaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<AreaEntity> findByBuildingId(Map<String, Object> params, Integer buildingId) {
		String sql = "FROM AreaEntity WHERE building_id = " + buildingId + "";
		Query query = entityManager.createQuery(sql, AreaEntity.class);
		return query.getResultList();
	}

	@Override
	public String joinCondition(Map<String, Object> params) {
		return null;
	}

}
