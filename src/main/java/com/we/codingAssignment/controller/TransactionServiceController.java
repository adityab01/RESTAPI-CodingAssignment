package com.we.codingAssignment.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.we.codingAssignment.model.Transaction;
import com.we.codingAssignment.service.TransactionsService;

@RestController
public class TransactionServiceController {

	@Autowired
	private TransactionsService transactionsService;

	@RequestMapping(value = "/transactions/{accountId}/page/{pageNumber}/size/{size}", method = RequestMethod.GET, produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE })
	
	public ResponseEntity<Iterable<Transaction>> getTransactions(
			@PathVariable("accountId") Integer accountId,
			@PathVariable(name = "pageNumber") Integer pageNumber,
			@PathVariable(name = "size") Integer size) throws JsonParseException, JsonMappingException, IOException {

		System.out.println("\n Received API request");
		Pageable pageable = PageRequest.of(pageNumber, size);
		Page<Transaction> accountsPage = this.transactionsService.fetchTransactionsByActID(accountId, pageable);
		
		return new ResponseEntity<Iterable<Transaction>>(accountsPage.getContent(), HttpStatus.OK);

	}

}