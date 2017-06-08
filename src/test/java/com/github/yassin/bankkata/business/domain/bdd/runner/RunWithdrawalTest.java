package com.github.yassin.bankkata.business.domain.bdd.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber/us2" },
        glue = "com.github.yassin.bankkata.business.domain.bdd.step",
        features = "classpath:cucumber/us2.feature"
)
public class RunWithdrawalTest {

}
