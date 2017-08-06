package com.healthdirect.ui.config;

import com.healthdirect.ui.utility.CucumberReport;
import com.healthdirect.ui.utility.config.ResourceManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Hooks {
    private WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(Hooks.class);
    private static com.healthdirect.ui.config.DriverHelper driverHelper = new com.healthdirect.ui.config.DriverHelper();
    private ResourceManager resourceManager;

    public Hooks(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
    }

    @Before(order = 1)
    public void beforeAll() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                driverHelper.closeAll();
                try {
                    new CucumberReport().generateReport();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Before(order = 10)
    public void setUp(Scenario scenario) throws Exception {
        driver = driverHelper.retrieveDriver();
    }


    @After(order = 1)
    /**
     * Embed a screenshot in test report if test is marked as failed
     */
    public void tearDown(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            try {
                byte[] somePlatformsDontSupportScreenshots = (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(somePlatformsDontSupportScreenshots, "image/jpeg");
            } catch (WebDriverException var3) {
                log.error(var3.getMessage(), var3);
            }
        }
        driverHelper.deleteAllCookies(driver);
        driverHelper.close(driver);
    }
}
