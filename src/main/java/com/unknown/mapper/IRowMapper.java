package com.unknown.mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
	public T mapRow(ResultSet resultSet);
}
