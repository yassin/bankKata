package com.github.yassin.bankkata.business.domain.tdd;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.yassin.bankkata.business.api.Account;
import com.github.yassin.bankkata.business.domain.BankAccount;
import com.github.yassin.bankkata.business.exceptions.TransactionException;

/**
 * BankAccountStatement Test
 * 
 * @author Yassin
 *
 */
public class BankAccountTest {

	private Account account;

	/**
	 * Setup of bank account of 1000 euro
	 * 
	 */
	@BeforeTest
	public void setUp() {
		account = new BankAccount(1000);
	}
	
	@Test(dataProviderClass = BankAccountTestDataProvider.class, dataProvider = "deposit_100")
	public void deposit_100_must_return_balance_1100(double d) {
		reset();
		try {
			Assert.assertEquals(account.deposit(d,"first deposit of 100"), true);
			Assert.assertEquals(account.getTotalBalance(), 1100.0);
			Assert.assertEquals(account.getStatement().size(), 1);
		} catch (TransactionException e) {
			Assert.fail();
		}
	}

	@Test(dataProviderClass = BankAccountTestDataProvider.class, dataProvider = "deposit_-100")
	public void deposit_minus_100_must_throw_transactionException_deposit_cant_be_negative(double d) {
		reset();
		try {
			account.deposit(d,"second deposit of -100");
			Assert.fail();
		} catch (TransactionException e) {
			Assert.assertEquals(account.getTotalBalance(), 1000.0);
			Assert.assertEquals(account.getStatement().size(), 0);
		}
	}
	
	@Test(dataProviderClass = BankAccountTestDataProvider.class, dataProvider = "deposit_100")
	public void deposit_two_time_100_must_return_2_statement_history(double d) {
		reset();
		try {
			account.deposit(d,"first deposit of 100");
			account.deposit(d,"second deposit of 100");
			Assert.assertEquals(account.getStatement().size(), 2);
		} catch (TransactionException e) {
			Assert.fail();
		}
	}

	@Test(dataProviderClass = BankAccountTestDataProvider.class, dataProvider = "withdraw_100")
	public void withdraw_100_must_return_balance_900(double d) {
		reset();
		try {
			Assert.assertEquals(account.withdraw(d), true);
			Assert.assertEquals(account.getTotalBalance(), 900.0);
		} catch (TransactionException e) {
			Assert.fail();
		}
	}
	
	@Test(dataProviderClass = BankAccountTestDataProvider.class, dataProvider = "withdraw_1000")
	public void withdraw_1000_must_return_balance_0(double d) {
		reset();
		try {
			Assert.assertEquals(account.withdraw(d), true);
			Assert.assertEquals(account.getTotalBalance(), 0.0);
		} catch (TransactionException e) {
			Assert.fail();
		}
	}

	@Test(dataProviderClass = BankAccountTestDataProvider.class, dataProvider = "withdraw_-100")
	public void withdraw_minus_100_must_throw_transactionException_withdraw_cant_be_negative(double d) {
		reset();
		try {
			Assert.assertEquals(account.withdraw(d), false);
			Assert.fail();
		} catch (TransactionException e) {
			Assert.assertEquals(account.getTotalBalance(), 1000.0);
		}
	}
	
	@Test(dataProviderClass = BankAccountTestDataProvider.class, dataProvider = "deposit_100")
	public void withdraw_two_time_100_must_return_2_statement_history(double d) {
		reset();
		try {
			account.withdraw(d);
			account.withdraw(d);
			Assert.assertEquals(account.getStatement().size(), 2);
		} catch (TransactionException e) {
			Assert.fail();
		}
	}

	@Test(dataProviderClass = BankAccountTestDataProvider.class, dataProvider = "withdraw_2000")
	public void withdraw_2000_must_throw_transactionException_insufficient_credit(double d) {
		reset();
		try {
			Assert.assertEquals(account.withdraw(d), false);
			Assert.fail();
		} catch (TransactionException e) {
			Assert.assertEquals(account.getTotalBalance(), 1000.0);
			Assert.assertEquals(e.getMessage(), "Insufficient credit");
		}
	}
	
	@Test
	public void printHistoryTest(){
		try {
			reset();
			account.deposit(100, "operation1");
			account.deposit(200, "operation2");
			account.withdraw(100);
			account.withdraw(200);
			String found = account.printHistory();
			
			Assert.assertTrue(found.contains("Date"));
			Assert.assertTrue(found.contains("Label"));
			Assert.assertTrue(found.contains("Amount"));
			Assert.assertTrue(found.contains("Balance"));
			
			Assert.assertTrue(found.contains("operation1"));
			Assert.assertTrue(found.contains("operation2"));
			Assert.assertTrue(found.contains("Withdrawal"));
			Assert.assertTrue(found.contains("Withdrawal"));
			
			Assert.assertTrue(found.contains("+100.0"));
			Assert.assertTrue(found.contains("+200.0"));
			Assert.assertTrue(found.contains("-100.0"));
			Assert.assertTrue(found.contains("-200.0"));
			
			Assert.assertTrue(found.contains("1100.0"));
			Assert.assertTrue(found.contains("1300.0"));
			Assert.assertTrue(found.contains("1200.0"));
			Assert.assertTrue(found.contains("1000.0"));
			
		} catch (TransactionException e) {
			Assert.fail();
		}
	}
	/**
	 * reset account to 1000 euro
	 */
	private void reset() {
		account = new BankAccount(1000);
	}

}
