package com.website.ui.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"},
        format = "pretty", features = "src/test/resources/features/", glue = {"com.website.ui.steps", "com.website.ui.config"}, tags = "@website")
public class RunCukesTest {
}




