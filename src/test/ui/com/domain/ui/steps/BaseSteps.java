package com.domain.ui.steps;

import com.domain.ui.config.DriverHelper;
import com.domain.ui.utility.config.ResourceManager;
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
