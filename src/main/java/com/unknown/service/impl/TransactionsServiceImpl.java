package com.unknown.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unknown.constant.TransactionTypeConstant;
import com.unknown.converter.TransactionsConverter;
import com.unknown.entity.TransactionEntity;
import com.unknown.entity.UsersEntity;
import com.unknown.model.request.TransactionsRequest;
import com.unknown.model.response.TransactionsResponse;
import com.unknown.model.response.TransactionsTypeResponse;
import com.unknown.repository.TransactionsRepository;
import com.unknown.repository.UsersRepository;
import com.unknown.service.AreaService;
import com.unknown.service.TransactionsService;
import com.unknown.service.TransactionsTypeService;

@Service
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	private TransactionsRepository transactionsRepository;

	@Autowired
	private TransactionsTypeService transactionsTypeService;

	@Autowired
	private TransactionsConverter transactionsConverter;

	@Autowired
	private AreaService areaService;

	@Autowired
	private UsersRepository usersRepository;

	@Override
	@Transactional
	public List<Integer> save(TransactionsRequest transactionsRequest) {
		List<Integer> areas = transactionsRequest.getAreaIds();
		List<TransactionEntity> transactionEntities = new ArrayList<TransactionEntity>();
		Boolean checkRent = checkTransactionsTypeRent(transactionsRequest.getTransactionTypeId());
		for (Integer item : areas) {
			TransactionEntity transactionEntity = transactionsConverter
					.convertTransactionsRequestToEntity(transactionsRequest, item);
			transactionEntities.add(transactionEntity);
			if (checkRent) {
				areaService.updateStatusById(item);
			}
		}
		List<TransactionEntity> reuslt = transactionsRepository.saveAll(transactionEntities);
		List<Integer> ids = new ArrayList<Integer>();
		reuslt.stream().forEach(item -> ids.add(item.getId()));
		return ids;
	}

	@Override
	public List<TransactionsResponse> findByCustomerId(Integer customerId) {
		UsersEntity usersEntity = usersRepository.findById(customerId).get();
		List<TransactionEntity> transactionEntities = usersEntity.getTransactionOfCustomer();
		List<TransactionsResponse> result = new ArrayList<TransactionsResponse>();
		transactionEntities.stream()
				.forEach(item -> result.add(transactionsConverter.convertEntityToTransactionsResponse(item)));
		return result;
	}

	private Boolean checkTransactionsTypeRent(Integer buildingTypeId) {
		TransactionsTypeResponse transactionsTypeResponse = transactionsTypeService.findById(buildingTypeId);
		if (!TransactionTypeConstant.RENT.equals(transactionsTypeResponse.getCode())) {
			return false;
		}
		return true;
	}
}
