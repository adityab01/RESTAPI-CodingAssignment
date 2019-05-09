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
import com.we.codingAssignment.service.AccountsService;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceControllerTest {

	@Mock
	private AccountsService accountsService;

	@InjectMocks
	private AccountServiceController accountsController;

	@Before
	public void setUp() {
		List<Account> accountsList = Stream
				.of(new Account(1234567, "TestACCTName", "Savings", new Date(0), "AUD", 99999.2),
						new Account(1234567, "TestACCTName2", "Current", new Date(0), "AUD", 10000.2))
				.collect(Collectors.toList());

		Page<Account> accountsPage = new PageImpl<Account>(accountsList);
		// Pageable pageable = PageRequest.of(0, 5);
		when(this.accountsService.fetchAllAccounts(any(Pageable.class))).thenReturn(accountsPage);
	}

	@Test
	public void test_getAccounts() throws JsonParseException, JsonMappingException, IOException {
		ResponseEntity<Iterable<Account>> accountsEntity = this.accountsController.getAccounts(0, 2);
		List<Account> accountsList = (List<Account>) accountsEntity.getBody();

		assertNotNull(accountsList);
		assertEquals(2, accountsList.size());

		Account account = accountsList.stream().findFirst().get();
		assertEquals("TestACCTName", account.getAccountName());
	}

}
