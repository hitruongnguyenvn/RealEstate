package com.unknown.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.entity.TransactionTypeEntity;
import com.unknown.model.response.TransactionsTypeResponse;

@Component
public class TransactionsTypeConverter {

	@Autowired
	private ModelMapper modelMapper;

	public TransactionsTypeResponse convertEntityToTransactionsTypeResponse(
			TransactionTypeEntity transactionTypeEntity) {
		TransactionsTypeResponse result = modelMapper.map(transactionTypeEntity, TransactionsTypeResponse.class);
		return result;
	}
}
