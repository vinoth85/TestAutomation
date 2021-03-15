package com.website.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void assertPage(String website) {
        switch (website){
            case "website":
                new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("CommBank - bank accounts, credit cards, home loans and insurance"));
                break;


        }

    }

}

