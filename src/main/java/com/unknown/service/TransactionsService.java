package com.unknown.service;

import java.util.List;

import com.unknown.model.request.TransactionsRequest;
import com.unknown.model.response.TransactionsResponse;

public interface TransactionsService {

	public List<Integer> save(TransactionsRequest transactionsRequest);

	public List<TransactionsResponse> findByCustomerId(Integer customerId);
}
