package com.github.yassin.bankkata.business.domain.tdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.yassin.bankkata.business.api.Statement;

/**
 * BankAccountStatement Test
 * 
 * @author Yassin
 *
 */
public class BankAccountStatementTest {

	@Test(dataProviderClass = BankAccountStatementTestDataProvider.class, dataProvider = "statement_2017-07-01_firstDeposite_+100_300")
	public void printCurrentTransaction_must_return_date_fisrtDeposite_plus_100_300(Statement s) {
		Assert.assertEquals(s.printCurrentStatement().replaceAll(" ", ""), "2017-07-01T00:00:00.000   firstDeposite   +100.0   300.0".replaceAll(" ", ""));
	}

	@Test(dataProviderClass = BankAccountStatementTestDataProvider.class, dataProvider = "statement_2017-07-01_firstWithdrawal_-100_300")
	public void printCurrentTransaction_must_return_date_fisrtWithdrawal_minus_100_300(Statement s) {
		Assert.assertEquals(s.printCurrentStatement().replaceAll(" ", ""), "2017-07-01T00:00:00.000     firstWithdrawal     -100.0     300.0".replaceAll(" ", ""));
	}

	@Test(dataProviderClass = BankAccountStatementTestDataProvider.class, dataProvider = "statement_transaction_null")
	public void printCurrentTransaction_must_return_empty_string(Statement s) {
		Assert.assertEquals(s.printCurrentStatement().replaceAll(" ", ""), "");
	}

}
