package com.unknown.repository.custom.impl;

import org.springframework.stereotype.Repository;

import com.unknown.entity.CityEntity;
import com.unknown.repository.custom.CityRepositoryCustom;

@Repository
public class CityRepositoryCustomImpl implements CityRepositoryCustom {

	@Override
	public CityEntity findByIdCustom(Integer id) {
		return null;
	}

}
