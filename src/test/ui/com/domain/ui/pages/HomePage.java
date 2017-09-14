package com.domain.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by 342813 on 5/08/2017.
 */
public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void assertPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Real Estate | Properties for Sale, Rent and Share | Domain"));
    }

}

