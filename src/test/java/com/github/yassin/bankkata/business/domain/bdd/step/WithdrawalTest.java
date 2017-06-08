package com.github.yassin.bankkata.business.domain.bdd.step;

import org.testng.Assert;

import com.github.yassin.bankkata.business.api.Account;
import com.github.yassin.bankkata.business.domain.BankAccount;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WithdrawalTest {

	private Account account;

	@Before
	public void setUp() {
		account = new BankAccount(0);
	}

	@Given("^I have an account with (\\d+) euros$")
	public void i_have_an_account_with_100_euros(double balance) throws Throwable {
		account = new BankAccount(balance);
		Assert.assertNotNull(account);
	}

	@When("^I make a withdrawal of (\\d+) euros$")
	public void i_make_a_withdrawal(double amount) throws Throwable {
		account.withdraw(amount);
	}

	@Then("^My balance should be (\\d+) euros$")
	public void the_balance_should_be_result(double result) throws Throwable {
		Assert.assertEquals(account.getTotalBalance(), result);
	}

}
