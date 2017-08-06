package com.healthdirect.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }



    public void validateResults(String searchText) {
        List<WebElement> searchElements = driver.findElements(By.cssSelector("#searchResults"));
        for (WebElement validationList : searchElements) {
            assertThat(validationList.getText().toLowerCase(), containsString(searchText.toLowerCase()));
        }
    }

    public void assertPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleContains("Search results for:"));
    }
}


