package com.unknown.service;

import java.util.List;

import com.unknown.model.response.TransactionsTypeResponse;

public interface TransactionsTypeService {
	List<TransactionsTypeResponse> findAll();

	TransactionsTypeResponse findById(Integer id);
}
