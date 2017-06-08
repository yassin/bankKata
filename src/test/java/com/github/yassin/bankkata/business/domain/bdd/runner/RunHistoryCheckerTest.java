package com.github.yassin.bankkata.business.domain.bdd.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber/us3" },
        glue = "com.github.yassin.bankkata.business.domain.bdd.step",
        features = "classpath:cucumber/us3.feature"
)
public class RunHistoryCheckerTest {

}
