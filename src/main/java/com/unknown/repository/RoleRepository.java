package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
	public RoleEntity findOneByCode(String code);
}
