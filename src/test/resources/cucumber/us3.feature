Feature: US 1
	In order to check my operations
	As a bank client
	I want to see the history (operation, date, amount, balance) of my operations
	
  Scenario: Deposit 100 euros and withdraw 50 euros ask to print history operation
    Given I have an account without operations and with 1000 euros
    When I make two deposit of 100 and 200 euros and two withdraw of 100 and 200 euros
    Then My history should print 4 operations and balance of 1000 euros