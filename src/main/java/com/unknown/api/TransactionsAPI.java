package com.unknown.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unknown.model.request.TransactionsRequest;
import com.unknown.service.TransactionsService;
import com.unknown.validation.TransactionsValidator;

@RestController(value = "apiTransactions")
@RequestMapping("/api/transactions")
public class TransactionsAPI {

	@Autowired
	private TransactionsService transactionsService;

	@PostMapping
	public List<Integer> insertTransactions(@RequestBody TransactionsRequest transactionsRequest) {
		TransactionsValidator.validation(transactionsRequest);
		return transactionsService.save(transactionsRequest);
	}
}
