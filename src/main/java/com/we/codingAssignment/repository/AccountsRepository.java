package com.we.codingAssignment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.we.codingAssignment.model.Account;

@Repository
public interface AccountsRepository extends PagingAndSortingRepository<Account, Long> {

	Page<Account> findAll(Pageable pageable);

} 