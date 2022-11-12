package com.unknown.validation;

import com.unknown.custom.exception.FieldNotFoundException;
import com.unknown.model.request.TransactionsRequest;

public class TransactionsValidator {

	public static void validation(TransactionsRequest transactionsRequest) {
		if (transactionsRequest.getAreaIds() == null || transactionsRequest.getAreaIds().isEmpty()) {
			throw new FieldNotFoundException("Area is required");
		}
	}
}
