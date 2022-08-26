package com.unknown.repository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.unknown.entity.BuildingEntity;
import com.unknown.repository.IBuildingRepository;

@Repository
@Primary
public class BuildingRepository implements IBuildingRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, List<String> buildingTypes) {
		// JPQL
		// String sql = "FROM BuildingEntity";
		// Query query = entityManager.createQuery(sql, BuildingEntity.class);
		// return query.getResultList();

		// NativeSQL
		String nativeSql = "SELECT * FROM building";
		Query nativeQuery = entityManager.createNativeQuery(nativeSql, BuildingEntity.class);
		return nativeQuery.getResultList();
	}

	@Override
	public BuildingEntity findById(Integer id) {
		String nativeSql = "SELECT * FROM building WHERE building.id = " + id + " ";
		Query nativeQuery = entityManager.createNativeQuery(nativeSql, BuildingEntity.class);
		return (BuildingEntity) nativeQuery.getSingleResult();
	}

}
