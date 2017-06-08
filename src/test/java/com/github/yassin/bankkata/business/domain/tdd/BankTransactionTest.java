package com.github.yassin.bankkata.business.domain.tdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.yassin.bankkata.business.api.Transaction;

/**
 * BankTransactionTest Test
 * 
 * @author Yassin
 *
 */
public class BankTransactionTest {

	@Test(dataProviderClass = BankTransactionTestDataProvider.class, dataProvider = "transaction_2017-07-01_firstDeposite_+100")
	public void printCurrentTransaction_must_return_date_fisrtDeposite_plus_100(Transaction t) {
		Assert.assertEquals(t.printCurrentTransaction().replaceAll(" ", ""), "2017-07-01T00:00:00.000      firstDeposite       +100.0".replaceAll(" ", ""));
	}

	@Test(dataProviderClass = BankTransactionTestDataProvider.class, dataProvider = "transaction_2017-07-01_firstWithdrawal_-100")
	public void printCurrentTransaction_must_return_date_fisrtWithdrawal_minus_100(Transaction t) {
		Assert.assertEquals(t.printCurrentTransaction().replaceAll(" ", ""), "2017-07-01T00:00:00.000      firstWithdrawal      -100.0".replaceAll(" ", ""));
	}

}
