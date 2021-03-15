package com.website.ui.steps;

import com.website.ui.config.DriverHelper;
import com.website.ui.utility.config.ResourceManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseSteps {

    protected WebDriver driver;
    protected ResourceManager resourceManager;

    public BaseSteps(ResourceManager resourceManager) {
        this.driver = DriverHelper.driver;
        this.resourceManager = resourceManager;
    }
}
