# bankKata

Summary
-------
program of Bank account management.

this program allow following operation :
	Deposit and Withdrawal
	Account statement (date, amount, balance)
	Statement printing

US 1:
	In order to save money
	As a bank client
	I want to make a deposit in my account

US 2:
	In order to retrieve some or all of my savings
	As a bank client
	I want to make a withdrawal from my account

US 3:
	In order to check my operations
	As a bank client
	I want to see the history (operation, date, amount, balance) of my operations

Dependencies
------------
* JDK 1.7
* Maven 3
* Log4j
* TestNG
* Cucmber


Compile & Run
-------------

    mvn clean package   

Javadoc
---------------------
Java Doc is generated in target/apidocs 
you can open index.html in the browser to see all javaDoc.

Coverage
---------------------
Coverage is generated in target/site/jacoco
you can open index.html in the browser to see reporting.

Test TDD
---------------------
TDD tests report  are  generated in target/surefire-reports 
you can open index.html in the browser to see reporting.

Test BDD
---------------------
TDD tests report  are  generated in target/cucumber 
you can open index.html in the browser to see reporting.


