Feature: US 1
	In order to save money
	As a bank client
	I want to make a deposit in my account
	
  Scenario: Deposit 100 euros and ask the statement balance
    Given I have an account
    When I make a deposit of 100 euros
    Then My balance should be 100 euross