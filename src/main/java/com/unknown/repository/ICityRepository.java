package com.unknown.repository;

import com.unknown.entity.CityEntity;

public interface ICityRepository {
	public CityEntity findById(Integer id);
}
