Feature: US 2
	In order to retrieve some or all of my savings
	As a bank client
	I want to make a withdrawal from my account
	
  Scenario: retrieve 100 euros and ask the statement balance
    Given I have an account with 100 euros
    When I make a withdrawal of 100 euros
    Then My balance should be 0 euros