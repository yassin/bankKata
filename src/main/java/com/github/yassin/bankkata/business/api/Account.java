package com.github.yassin.bankkata.business.api;

import java.util.List;

import com.github.yassin.bankkata.business.exceptions.TransactionException;

/**
 * Account is defining all statement performed by Client
 * 
 * @author Yassin
 *
 */
public interface Account {

	/**
	 * Make a deposit in account
	 * 
	 * @param amount
	 *            : amount of operation
	 * @param label
	 *            : label of operation
	 * @return true if operation made successfully
	 */
	public boolean deposit(double amount, String label) throws TransactionException;

	/**
	 * Make a withdraw from account
	 * 
	 * @param amount
	 *            : amount of operation
	 * @return true if operation made successfully
	 */
	public boolean withdraw(double amount) throws TransactionException;

	/**
	 * Get all history statement account
	 * 
	 * @return history
	 */
	public List<Statement> getStatement();

	/**
	 * Get total account balance
	 * 
	 * @return balance
	 */
	public double getTotalBalance();
	

	/**
	 * Print statement history
	 * 
	 * @return String
	 */
	public String printHistory();

}
