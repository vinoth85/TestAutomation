package com.website.ui.steps;

import com.website.ui.pages.HomePage;
import com.website.ui.pages.MegaMenuPage;
import com.website.ui.utility.config.ResourceManager;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogonSteps extends BaseSteps {


    public LogonSteps(ResourceManager resourceManager) {
        super(resourceManager);
    }


    @And("^I logon to commbank$")
    public void i_Logon_CommBank() throws Throwable {

        WebElement logon = driver.findElement(By.xpath("//span[contains(text(),'Log on')]"));
        logon.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'NetBank log on ')]")));
        WebElement netBankLogon = driver.findElement(By.xpath("//a[contains(text(),'NetBank log on ')]"));
        netBankLogon.click();
    }


    @And("^I validate the login screen appears$")
    public void iValidateTheLoginScreenAppears() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("txtMyClientNumber_field")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("txtMyPassword_field")));
    }
}
