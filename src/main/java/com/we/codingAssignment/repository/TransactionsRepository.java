package com.we.codingAssignment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.we.codingAssignment.model.Transaction;

@Repository
public interface TransactionsRepository extends PagingAndSortingRepository<Transaction, Integer> {

    @Query("from Transaction t where t.account.accountNumber =:accountId order by t.balanceDate desc")
    Page<Transaction> getTransactionsByAccountId(@Param("accountId") Integer accountId, Pageable pageable);
}