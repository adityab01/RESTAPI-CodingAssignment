package com.we.codingAssignment.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

@Table(name = "TRANSACTIONS")
public class Transaction {
	
	@Id
	@Column(name = "id")
	private Integer identifier;
	
	@ManyToOne
	@JoinColumn(name="ACCT_NUMBER", nullable = false)
	private Account account;
	
	@Column(name ="BALANCE_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date balanceDate;
	
	@Column(name="CURRENCY")
    private String currency;

    @Column(name="DEBIT_AMT")
    private Double debitAmount;

    @Column(name = "CREDIT_AMT")
    private Double creditAmount;

    @Column(name = "DRCR_TYPE")
    private String drcrType;
    
    @Column(name = "TXN_NARRATIVE")
    private String narrative;
    

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(Double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public Double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(Double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getDrcrType() {
		return drcrType;
	}

	public void setDrcrType(String drcrType) {
		this.drcrType = drcrType;
	}

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public Transaction() {
		
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public Transaction(Integer identifier, Account account, Date balanceDate, String currency, Double debitAmount,
			Double creditAmount, String drcrType, String narrative) {
		super();
		this.identifier = identifier;
		this.account = account;
		this.balanceDate = balanceDate;
		this.currency = currency;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.drcrType = drcrType;
		this.narrative = narrative;
	}

    	
}