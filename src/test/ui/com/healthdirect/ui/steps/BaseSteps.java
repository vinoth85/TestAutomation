package com.healthdirect.ui.steps;

import com.healthdirect.ui.config.DriverHelper;
import com.healthdirect.ui.utility.config.ResourceManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public abstract class BaseSteps {

    protected WebDriver driver;
    protected ResourceManager resourceManager;

    public BaseSteps(ResourceManager resourceManager) {
        this.driver = DriverHelper.driver;
        this.resourceManager = resourceManager;
    }
}
