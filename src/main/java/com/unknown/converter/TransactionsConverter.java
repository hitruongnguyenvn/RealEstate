package com.unknown.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.unknown.entity.AreaEntity;
import com.unknown.entity.TransactionEntity;
import com.unknown.entity.TransactionTypeEntity;
import com.unknown.entity.UsersEntity;
import com.unknown.model.request.TransactionsRequest;
import com.unknown.model.response.TransactionsResponse;

@Component
public class TransactionsConverter {

	@Autowired
	private ModelMapper modelMapper;

	public TransactionsResponse convertEntityToTransactionsResponse(TransactionEntity transactionEntity) {
		TransactionsResponse result = modelMapper.map(transactionEntity, TransactionsResponse.class);
		result.setBuildingName(transactionEntity.getAreaEntity().getBuildingEntity().getName());
		result.setFloor(transactionEntity.getAreaEntity().getFloor());
		result.setArea(transactionEntity.getAreaEntity().getArea());
		result.setPrice(transactionEntity.getAreaEntity().getPrice());
		result.setTransactionType(transactionEntity.getTransactionTypeEntity().getName());
		return result;
	}

	public TransactionEntity convertTransactionsRequestToEntity(TransactionsRequest transactionsRequest,
			Integer areaId) {
		TransactionEntity result = new TransactionEntity();
		UsersEntity customer = new UsersEntity();
		UsersEntity employee = new UsersEntity();
		TransactionTypeEntity transactionTypeEntity = new TransactionTypeEntity();
		AreaEntity areaEntity = new AreaEntity();
		customer.setId(transactionsRequest.getCustomerId());
		employee.setId(transactionsRequest.getEmployeeId());
		transactionTypeEntity.setId(transactionsRequest.getTransactionTypeId());
		areaEntity.setId(areaId);
		result.setCustomer(customer);
		result.setEmployee(employee);
		result.setTransactionTypeEntity(transactionTypeEntity);
		result.setAreaEntity(areaEntity);
		result.setNote(transactionsRequest.getNote());
		return result;
	}
}
