package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.UsersEntity;
import com.unknown.repository.custom.UsersRepositoryCustom;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer>, UsersRepositoryCustom {
	public UsersEntity findOneByUserName(String userName);
}
