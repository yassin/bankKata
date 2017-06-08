package com.github.yassin.bankkata.business.domain.tdd;

import org.joda.time.LocalDateTime;
import org.testng.annotations.DataProvider;

import com.github.yassin.bankkata.business.api.Statement;
import com.github.yassin.bankkata.business.api.Transaction;
import com.github.yassin.bankkata.business.domain.BankAccountStatement;
import com.github.yassin.bankkata.business.domain.BankTransaction;
import com.github.yassin.bankkata.business.enums.TransactionType;

/**
 * BankAccountStatementTest Data Provider
 * 
 * @author Yassin
 *
 */
public class BankAccountStatementTestDataProvider {

	@DataProvider(name = "statement_2017-07-01_firstDeposite_+100_300")
	public static Object[][] statement_07062017_firstDeposite_100_300() {
		Transaction transaction = new BankTransaction(TransactionType.DEPOSITE, 100, LocalDateTime.parse("2017-07-01"), "firstDeposite");
		Statement statement = new BankAccountStatement(transaction, 300);
		return new Object[][] { { statement } };
	}

	@DataProvider(name = "statement_2017-07-01_firstWithdrawal_-100_300")
	public static Object[][] statement_07062017_firstwithDraw_100_300() {
		Transaction transaction = new BankTransaction(TransactionType.WITHDRAWAL, 100, LocalDateTime.parse("2017-07-01"), "firstWithdrawal");
		Statement statement = new BankAccountStatement(transaction, 300);
		return new Object[][] { { statement } };
	}

	@DataProvider(name = "statement_transaction_null")
	public static Object[][] statement_transaction_null() {
		Statement statement = new BankAccountStatement(null, 300);
		return new Object[][] { { statement } };
	}

}
