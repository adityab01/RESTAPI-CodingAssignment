package com.we.codingAssignment.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity

@Table(name = "ACCOUNT")
public class Account {
	
	//private @Id @GeneratedValue Long id;
	@Id
	@Column (name = "ACCT_NUMBER")
	private int accountNumber;
	
	@Column(name = "ACCT_NAME")
	private String accountName;
	
	@Column(name ="ACCT_TYPE")
	private String accountType;
	
	@Column(name ="BALANCE_DATE") 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date balanceDate;
	
	@Column(name="CURRENCY")
	private String currency;
	
	@Column(name = "OPENING_BALANCE")
	private double openingBalance;
	
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public Account() {
			
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public Account(int accountNumber, String accountName, String accountType, Date balanceDate, String currency,
			double openingBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balanceDate = balanceDate;
		this.currency = currency;
		this.openingBalance = openingBalance;
	}
	

	
	
}