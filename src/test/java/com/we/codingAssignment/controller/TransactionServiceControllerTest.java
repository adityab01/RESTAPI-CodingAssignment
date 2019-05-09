package com.we.codingAssignment.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.we.codingAssignment.model.Account;
import com.we.codingAssignment.model.Transaction;
import com.we.codingAssignment.service.TransactionsService;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceControllerTest {

	@Mock
	private TransactionsService transactionsService;

	@InjectMocks
	private TransactionServiceController transactionsController;
	
	@Before
	public void setUp() {
		
		Account accountObj = new Account(1234567, "TestACCTName", "Savings", new Date(0), "AUD", 99999.2);
		Account accountObj1 = new Account(1234567, "TestACCTName2", "Current", new Date(0), "FJD", 99999.2);
		
		List<Transaction> transactionList = Stream
				.of(new Transaction(1,accountObj,new Date(0),"FJD",123.4,145.6,"CR", "Test Trn"), new Transaction(1,accountObj1,new Date(0),"FJD",123.4,134.6,"CR", "Test Trn"))
				.collect(Collectors.toList());

		Page<Transaction> transactionPage = new PageImpl<Transaction>(transactionList);
		// Pageable pageable = PageRequest.of(0, 5);
		when(this.transactionsService.fetchTransactionsByActID(any(),any(Pageable.class))).thenReturn(transactionPage);
	}

	@Test
	public void test_getTransactions() throws JsonParseException, JsonMappingException, IOException {
		ResponseEntity<Iterable<Transaction>> transactionEntity = this.transactionsController.getTransactions(1234567,0, 2);
		List<Transaction> transactionsList = (List<Transaction>) transactionEntity.getBody();

		assertNotNull(transactionsList);
		assertEquals(2, transactionsList.size());

		Transaction transaction = transactionsList.stream().findFirst().get();
		assertEquals("FJD", transaction.getCurrency());
	}

}
