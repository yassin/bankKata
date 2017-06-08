package com.github.yassin.bankkata.business.domain.tdd;

import org.joda.time.LocalDateTime;
import org.testng.annotations.DataProvider;

import com.github.yassin.bankkata.business.api.Transaction;
import com.github.yassin.bankkata.business.domain.BankTransaction;
import com.github.yassin.bankkata.business.enums.TransactionType;

/**
 * BankTransactionTest Data Provider
 * 
 * @author Yassin
 *
 */
public class BankTransactionTestDataProvider {

	@DataProvider(name = "transaction_2017-07-01_firstDeposite_+100")
	public static Object[][] transaction_07062017_firstDeposite_100() {
		Transaction transaction = new BankTransaction(TransactionType.DEPOSITE, 100, LocalDateTime.parse("2017-07-01"), "firstDeposite");
		return new Object[][] { { transaction } };
	}

	@DataProvider(name = "transaction_2017-07-01_firstWithdrawal_-100")
	public static Object[][] transaction_07062017_firstwithDraw_100() {
		Transaction transaction = new BankTransaction(TransactionType.WITHDRAWAL, 100, LocalDateTime.parse("2017-07-01"), "firstWithdrawal");
		return new Object[][] { { transaction } };
	}

}
