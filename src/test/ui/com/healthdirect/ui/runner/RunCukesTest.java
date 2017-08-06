package com.healthdirect.ui.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        format = "pretty", features = "src/test/resources/features/", glue = {"com.healthdirect.ui.steps", "com.healthdirect.ui.config"}, tags = "@search")
public class RunCukesTest {
}
