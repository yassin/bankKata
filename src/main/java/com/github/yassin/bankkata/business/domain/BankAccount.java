package com.github.yassin.bankkata.business.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.joda.time.LocalDateTime;

import com.github.yassin.bankkata.business.api.Account;
import com.github.yassin.bankkata.business.api.Statement;
import com.github.yassin.bankkata.business.api.Transaction;
import com.github.yassin.bankkata.business.enums.TransactionType;
import com.github.yassin.bankkata.business.exceptions.TransactionException;

/**
 * Implementation of bank Account
 * 
 * @author Yassin
 *
 */
public class BankAccount implements Account, Iterable<Statement> {

	private List<Statement> statement = new ArrayList<Statement>();

	private double totalBalance;

	public BankAccount(double totalBalance) {
		super();
		this.totalBalance = totalBalance;
	}

	@Override
	public boolean deposit(double amount, String label) throws TransactionException {
		if (amount >= 0) {
			Transaction transaction = new BankTransaction(TransactionType.DEPOSITE, amount, LocalDateTime.now(), label);
			Statement bankAccountStatement = new BankAccountStatement(transaction, totalBalance = totalBalance + amount);
			statement.add(bankAccountStatement);
			return true;
		} else {
			throw new TransactionException("Amount can't be negative");
		}
	}

	@Override
	public boolean withdraw(double amount) throws TransactionException {
		if (amount >= 0 && amount <= totalBalance) {
			Transaction transaction = new BankTransaction(TransactionType.WITHDRAWAL, amount, LocalDateTime.now(), "Withdrawal");
			Statement bankAccountStatement = new BankAccountStatement(transaction, totalBalance = totalBalance - amount);
			statement.add(bankAccountStatement);
			return true;
		} else {
			throw new TransactionException((amount < 0) ? ("Amount can't be negative") : amount > totalBalance ? ("Insufficient credit") : "Error");
		}
	}

	@Override
	public Iterator<Statement> iterator() {
		Iterator<Statement> iStatement = statement.iterator();
		return iStatement;
	}

	@Override
	public List<Statement> getStatement() {
		return Collections.unmodifiableList(statement);
	}

	@Override
	public double getTotalBalance() {
		return totalBalance;
	}

	@Override
	public String printHistory() {
		StringBuilder result = new StringBuilder();
		result.append("      Date                    Label        Amount     Balance");
		result.append("\n");
		for (Statement statement : this) {
			result.append(statement.printCurrentStatement());
			result.append("\n");
		}
		return result.toString();
	}

}
