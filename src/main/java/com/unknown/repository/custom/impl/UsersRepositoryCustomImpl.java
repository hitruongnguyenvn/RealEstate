package com.unknown.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.unknown.constant.RoleConstant;
import com.unknown.constant.SystemConstant;
import com.unknown.entity.UsersEntity;
import com.unknown.model.request.CustomerRequest;
import com.unknown.repository.custom.UsersRepositoryCustom;
import com.unknown.utils.StringUtils;

@Repository
@Primary
public class UsersRepositoryCustomImpl implements UsersRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UsersEntity> findByRoleId(Integer id) {
		String queryJpql = "FROM UsersEntity u WHERE u.roleEntity = " + id + "";
		List<UsersEntity> results = entityManager.createQuery(queryJpql, UsersEntity.class).getResultList();
		return results;
	}

	@Override
	public List<UsersEntity> findByTwoRole(String roleFirst, String roleSecond) {
		String queryJpql = "FROM UsersEntity u WHERE u.roleEntity.code = '" + roleFirst + "' OR u.roleEntity.code = '"
				+ roleSecond + "'";
		List<UsersEntity> results = entityManager.createQuery(queryJpql, UsersEntity.class).getResultList();
		return results;
	}

	/*
	 * public List<UsersEntity> findCustomerJpql(CustomerRequest customerRequest) {
	 * StringBuilder queryJpql = new StringBuilder(
	 * "FROM UsersEntity u WHERE u.roleEntity.code = '" + RoleConstant.USER + "'");
	 * queryJpql = buildSqlCommonJpql(customerRequest, queryJpql); List<UsersEntity>
	 * results = entityManager.createQuery(queryJpql.toString(),
	 * UsersEntity.class).getResultList(); return results; }
	 * 
	 * public StringBuilder buildSqlCommonJpql(CustomerRequest customerRequest,
	 * StringBuilder queryJpql) { String role = customerRequest.getRole(); if
	 * (!RoleConstant.ROLE_MANAGE.equals(role)) { if (customerRequest.getManagerId()
	 * != null) { queryJpql.append(" AND u.usersEntity.id = " +
	 * customerRequest.getManagerId() + ""); } } if
	 * (!StringUtils.isNullOrEmpty(customerRequest.getGender())) {
	 * queryJpql.append(" AND u.gender LIKE '%" + customerRequest.getGender() +
	 * "%'"); } if (!StringUtils.isNullOrEmpty(customerRequest.getPhoneNumber())) {
	 * queryJpql.append(" AND u.phoneNumber LIKE '%" +
	 * customerRequest.getPhoneNumber() + "%'"); } if
	 * (!StringUtils.isNullOrEmpty(customerRequest.getName())) {
	 * queryJpql.append(" AND u.name LIKE '%" + customerRequest.getName() + "%'"); }
	 * return queryJpql; }
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersEntity> findCustomer(CustomerRequest customerRequest) {
		StringBuilder nativeSql = new StringBuilder("SELECT * FROM users");
		nativeSql = buildSqlJoining(customerRequest, nativeSql);
		nativeSql.append(" " + SystemConstant.ONE_EQUAL_ONE);
		nativeSql = buildSqlCommon(customerRequest, nativeSql);
		// List<UsersEntity> results = entityManager.createQuery(queryNative.toString(),
		// UsersEntity.class)
		// .getResultList();
		Query nativeQuery = entityManager.createNativeQuery(nativeSql.toString(), UsersEntity.class);
		return nativeQuery.getResultList();
	}

	public StringBuilder buildSqlJoining(CustomerRequest customerRequest, StringBuilder nativeSql) {
		nativeSql.append(" INNER JOIN role ON users.role_id = role.id AND role.code = '" + RoleConstant.USER + "'");
		return nativeSql;
	}

	public StringBuilder buildSqlCommon(CustomerRequest customerRequest, StringBuilder nativeSql) {
		String role = customerRequest.getRole();
		if (!RoleConstant.ROLE_MANAGE.equals(role)) {
			if (customerRequest.getManagerId() != null) {
				nativeSql.append(" AND users.manager_id = " + customerRequest.getManagerId() + "");
			}
		}
		if (!StringUtils.isNullOrEmpty(customerRequest.getGender())) {
			nativeSql.append(" AND users.gender LIKE '%" + customerRequest.getGender() + "%'");
		}
		if (!StringUtils.isNullOrEmpty(customerRequest.getPhoneNumber())) {
			nativeSql.append(" AND users.phone_number LIKE '%" + customerRequest.getPhoneNumber() + "%'");
		}
		if (!StringUtils.isNullOrEmpty(customerRequest.getName())) {
			nativeSql.append(" AND users.full_name LIKE '%" + customerRequest.getName() + "%'");
		}
		return nativeSql;
	}

}
