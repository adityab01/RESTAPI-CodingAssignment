package com.we.codingAssignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.we.codingAssignment.model.Transaction;
import com.we.codingAssignment.repository.TransactionsRepository;

@Service
public class TransactionsService {

	@Autowired
	private TransactionsRepository transactionRepository;

	public Page<Transaction> fetchTransactionsByActID(Integer accountId, Pageable pageable) {
		return transactionRepository.getTransactionsByAccountId(accountId, pageable);
	}

}