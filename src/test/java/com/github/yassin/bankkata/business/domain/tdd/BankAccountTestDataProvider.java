package com.github.yassin.bankkata.business.domain.tdd;

import org.testng.annotations.DataProvider;

/**
 * BankAccountTest Data Provider
 * 
 * @author Yassin
 *
 */
public class BankAccountTestDataProvider {

	@DataProvider(name = "deposit_100")
	public static Object[][] deposit_100() {
		double d = 100;
		return new Object[][] { { d } };
	}

	@DataProvider(name = "deposit_-100")
	public static Object[][] deposit_minus_100() {
		double d = -100;
		return new Object[][] { { d } };
	}

	@DataProvider(name = "withdraw_100")
	public static Object[][] withdraw_100() {
		double d = 100;
		return new Object[][] { { d } };
	}

	@DataProvider(name = "withdraw_-100")
	public static Object[][] withdraw_minus_100() {
		double d = -100;
		return new Object[][] { { d } };
	}

	@DataProvider(name = "withdraw_2000")
	public static Object[][] withdraw_2000() {
		double d = 2000;
		return new Object[][] { { d } };
	}
	
	@DataProvider(name = "withdraw_1000")
	public static Object[][] withdraw_1000() {
		double d = 1000;
		return new Object[][] { { d } };
	}

}
