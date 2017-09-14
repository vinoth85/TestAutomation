package com.domain.ui.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        format = "pretty", features = "src/test/resources/features/", glue = {"com.domain.ui.steps", "com.domain.ui.config"}, tags = "@navigation")
public class RunCukesTest {
}
