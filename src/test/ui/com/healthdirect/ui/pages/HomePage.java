package com.healthdirect.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by 342813 on 5/08/2017.
 */
public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void assertPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Trusted Health Advice | healthdirect"));
    }


    public void clickSearch() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-form-node-desktop-mode > button.hda-head_menu-row-tablet-search-submit")));
        driver.findElement(By.cssSelector("#search-form-node-desktop-mode > button.hda-head_menu-row-tablet-search-submit")).click();
    }


    public void selectSearchText(String searchText, String selectValue) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search-form-node-desktop-mode > #header-search")));
        WebElement searchTextElement = driver.findElement(By.cssSelector("#search-form-node-desktop-mode > #header-search"));
        searchTextElement.click();
        searchTextElement.sendKeys(searchText);
        this.selectDropDown(By.cssSelector("#search-form-node-desktop-mode > #header-search"), By.cssSelector(".dropdown-menu li"), selectValue);

    }

    public void selectDropDown(By inputBy, By dropDownListBoxby, String value) {
        this.getDropDownInputElement(inputBy).click();
        List<WebElement> dropDownOptions = getDropDownOptionsElements(dropDownListBoxby);
        if (dropDownOptions != null && dropDownOptions.size() > 0) {
            for (WebElement option : dropDownOptions) {
                if (option.getText().equalsIgnoreCase(value)) {
                    option.click();
                    return;
                }
            }
        }
    }

    public WebElement getDropDownInputElement(By by) {
        return this.driver.findElement(by);
    }


    public List<WebElement> getDropDownOptionsElements(By dropDownListBoxby) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(dropDownListBoxby));
        return this.driver.findElements(dropDownListBoxby);
    }

}

