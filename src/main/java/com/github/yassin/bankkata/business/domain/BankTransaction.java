package com.github.yassin.bankkata.business.domain;

import org.joda.time.LocalDateTime;

import com.github.yassin.bankkata.business.api.Transaction;
import com.github.yassin.bankkata.business.enums.TransactionType;

/**
 * Implementation of bank transaction
 * 
 * @author Yassin
 *
 */
public class BankTransaction implements Transaction {

	private TransactionType type;

	private double amount;

	private LocalDateTime date;

	private String label;

	public BankTransaction(TransactionType type, double amount, LocalDateTime date, String label) {
		super();
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.label = label;
	}

	@Override
	public String printCurrentTransaction() {
		if (this.type.equals(TransactionType.DEPOSITE)) {
			return (this.date.toString()!=null?this.date.toString():"N/A") + "     " + (this.label!=null?this.label:"N/A") + "     +" + this.amount;
		} else if (this.type.equals(TransactionType.WITHDRAWAL)) {
			return (this.date.toString()!=null?this.date.toString():"N/A") + "     " + (this.label!=null?this.label:"N/A") + "     -" + this.amount;
		}
		return "";
	}

}
