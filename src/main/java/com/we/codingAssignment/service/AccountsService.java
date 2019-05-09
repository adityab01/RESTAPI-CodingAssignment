package com.we.codingAssignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.we.codingAssignment.model.Account;
import com.we.codingAssignment.repository.AccountsRepository;

@Service
public class AccountsService {

	@Autowired
	private AccountsRepository accountRepository;

	
	public Page<Account> fetchAllAccounts(Pageable pageable) {
		
		System.out.println("\n Inside AccountsService: fetchAllAccounts");
		return accountRepository.findAll(pageable);
	}

}