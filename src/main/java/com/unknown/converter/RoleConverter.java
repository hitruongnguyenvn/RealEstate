package com.unknown.converter;

import org.springframework.stereotype.Component;

import com.unknown.constant.RoleConstant;

@Component
public class RoleConverter {
	public String convertRoleToRoleSQL(String role) {
		switch (role) {
		case RoleConstant.ROLE_USER:
			return RoleConstant.USER;
		case RoleConstant.ROLE_ADMIN:
			return RoleConstant.ADMIN;
		case RoleConstant.ROLE_MANAGE:
			return RoleConstant.MANAGE;
		default:
			return "";
		}
	}
}
