package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.converter.TransactionsTypeConverter;
import com.unknown.entity.TransactionTypeEntity;
import com.unknown.model.response.TransactionsTypeResponse;
import com.unknown.repository.TransactionsTypeRepository;
import com.unknown.service.TransactionsTypeService;

@Service
public class TransactionsTypeServiceImpl implements TransactionsTypeService {

	@Autowired
	private TransactionsTypeRepository transactionsTypeRepository;

	@Autowired
	private TransactionsTypeConverter transactionsTypeConverter;

	@Override
	public List<TransactionsTypeResponse> findAll() {
		List<TransactionTypeEntity> transactionTypeEntities = transactionsTypeRepository.findAll();
		List<TransactionsTypeResponse> result = new ArrayList<TransactionsTypeResponse>();
		transactionTypeEntities.stream()
				.forEach(item -> result.add(transactionsTypeConverter.convertEntityToTransactionsTypeResponse(item)));
		return result;
	}

	@Override
	public TransactionsTypeResponse findById(Integer id) {
		TransactionTypeEntity transactionTypeEntity = transactionsTypeRepository.findById(id).get();
		TransactionsTypeResponse result = transactionsTypeConverter
				.convertEntityToTransactionsTypeResponse(transactionTypeEntity);
		return result;
	}

}
