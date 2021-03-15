package com.website.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MegaMenuPage extends BasePage {

    public MegaMenuPage(WebDriver driver) {
        super(driver);
    }


    public void navigateTabsForWebsite() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".commbank-header")));
        WebElement ele = driver.findElement(By.xpath("*"));
        List<WebElement> allLinks = driver.findElements(By.xpath("//ul[@class='commbank-list']/li[@role='listitem']/a"));
        int linkCount = 0;
        int sizeOfAllLinks = allLinks.size();
        String linkText = null;
        for (int index = 1; index < sizeOfAllLinks; index++) {
             allLinks = driver.findElements(By.xpath("//ul[@class='commbank-list']/li[@role='listitem']/a"));
            linkText = allLinks.get(index).getText();
            getElementWithIndex(By.xpath("//ul[@class='commbank-list']/li[@role='listitem']/a"), index).click();


            linkCount++;
            switch (linkText) {
                case "Banking":
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Banking - CommBank"));
                    assertEquals(driver.getCurrentUrl(), "https://www.commbank.com.au/banking.html?ei=mv_banking");
                    navigateBack();
                    driver.navigate().refresh();
                    break;
                case "Home loans":
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Home loans - calculators, guides and compare - CommBank"));
                    assertEquals(driver.getCurrentUrl(), "https://www.commbank.com.au/home-loans.html?ei=mv_home-loans");
                    navigateBack();
                    break;
                case "Insurance":
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Insurance - CommBank"));
                    assertEquals(driver.getCurrentUrl(), "https://www.commbank.com.au/insurance.html?ei=mv_insurance");
                    navigateBack();
                    break;
                case "Investing & super":
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Investing & Super - CommBank"));
                    assertEquals(driver.getCurrentUrl(), "https://www.commbank.com.au/investing-and-super.html?ei=mv_investing-super");
                    break;
                default:
                    break;
            }
        }
    }


    private WebElement getElementWithIndex(By a, int index) {
        List<WebElement> elements = driver.findElements(By.xpath("//ul[@class='commbank-list']/li[@role='listitem']/a"));
        return elements.get(index);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public String getTextFromDropDownList(String text) {
        String visibleText = driver.findElement(By.xpath("//button[contains(text(),'" + text + "')]")).getText();
        return visibleText;
    }

    public List<String> getPrimaryTabs(String text) {

        List<WebElement> tabElements = getTabElements(text);
        List<String>  primaryTabs = tabElements.stream().map(WebElement::getText).collect(Collectors.toList());
        return primaryTabs;

    }

    public List<String> getSubTopics(String text) {

        List<WebElement> tabElements = getTabElements(text);
        List<String>  primaryTabs = tabElements.stream().map(WebElement::getText).collect(Collectors.toList());
        return primaryTabs;

    }

    private List<WebElement> getTabElements(String text) {
        List<WebElement> elements;
        switch(text){
            case "website":
                elements= driver.findElements(By.xpath("//ul[@class='commbank-list']/li[@role='listitem']"));
                break;
            case "Banking" :
                elements = driver.findElements(By.xpath("//div[@class = 'section-navigation']//ul/li"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + text);
        }
        return elements;
    }

    public WebElement getBankingElement(){
        WebElement element = driver.findElement(By.xpath("//ul[@class='commbank-list']/li[@role='listitem']/a[contains(text(),'Banking')]"));
        return element;
    }

}


