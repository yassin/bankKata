package com.github.yassin.bankkata.business.domain.bdd.step;

import org.testng.Assert;

import com.github.yassin.bankkata.business.api.Account;
import com.github.yassin.bankkata.business.domain.BankAccount;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HistoryPrintTest {

	private Account account;

	@Before
	public void setUp() {
		account = new BankAccount(0);
	}

	@Given("^I have an account without operations and with (\\d+) euros$")
	public void i_have_an_account_without_operation(double balance) throws Throwable {
		account = new BankAccount(balance);
		Assert.assertNotNull(account);
		Assert.assertEquals(account.getStatement().size(), 0);
	}

	@When("^I make two deposit of (\\d+) and (\\d+) euros and two withdraw of (\\d+) and (\\d+) euros$")
	public void i_make_a_withdrawal(double deposit1,double deposit2,double withdrawal1,double withdrawal2) throws Throwable {
		account.deposit(deposit1, "operation1");
		account.deposit(deposit2, "operation2");
		account.withdraw(withdrawal1);
		account.withdraw(withdrawal2);
	}

	@Then("^My history should print (\\d+) operations and balance of (\\d+) euros$")
	public void the_balance_should_be_result(int operationNumber,double balance) throws Throwable {
		Assert.assertEquals(account.getStatement().size(), operationNumber);
		Assert.assertEquals(account.getTotalBalance(), balance);
		
		
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
	}

}
