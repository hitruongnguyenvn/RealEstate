package com.unknown.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.unknown.repository.custom.UsersBuildingRepositoryCustom;

@Repository
@Primary
public class UsersBuildingRepositoryCustomImpl implements UsersBuildingRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void deleteByBuildingIdAnUsersId(Integer buildingId, Integer usersId) {
		String queryJpql = "DELETE FROM UsersBuildingEntity U WHERE U.buildingEntity = " + buildingId
				+ " AND U.usersEntity = " + usersId + "";
		entityManager.createQuery(queryJpql).executeUpdate();
	}

}
