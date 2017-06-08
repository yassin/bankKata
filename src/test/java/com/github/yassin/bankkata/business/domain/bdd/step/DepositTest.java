package com.github.yassin.bankkata.business.domain.bdd.step;

import org.testng.Assert;

import com.github.yassin.bankkata.business.api.Account;
import com.github.yassin.bankkata.business.domain.BankAccount;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DepositTest {

	private Account account;

	@Before
	public void setUp() {
		account = new BankAccount(0);
	}

	@Given("^I have an account$")
	public void i_have_an_account() throws Throwable {
		Assert.assertNotNull(account);
	}

	@When("^I make a deposit of (\\d+) euros$")
	public void i_make_a_deposit(double amount) throws Throwable {
		account.deposit(amount, "first operation");
	}

	@Then("^My balance should be (\\d+) euross$")
	public void the_balance_should_be_result(double result) throws Throwable {
		Assert.assertEquals(account.getTotalBalance(), result);
	}

}
