package com.github.yassin.bankkata.business.domain;

import com.github.yassin.bankkata.business.api.Statement;
import com.github.yassin.bankkata.business.api.Transaction;

/**
 * Implementation of bank Account Statement
 * 
 * @author Yassin
 *
 */
public class BankAccountStatement implements Statement{

	private Transaction transaction ;
	private double balance ;
	
	public BankAccountStatement(Transaction transaction, double balance) {
		super();
		this.transaction = transaction;
		this.balance = balance;
	}

	@Override
	public String printCurrentStatement() {
		if(this.transaction != null){
			return this.transaction.printCurrentTransaction() + "     " + this.balance ;
		}
		return "";
	}
}
