package com.github.yassin.bankkata.business.exceptions;

/**
 * BankTransaction exception threw when account owner make a deposit or withdraw 
 * 
 * @author Yassin
 *
 */
public class TransactionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransactionException(String message) {
		super(message);
	}

}
