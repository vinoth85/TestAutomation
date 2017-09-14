package com.domain.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MegaMenuPage extends BasePage {

    public MegaMenuPage(WebDriver driver) {
        super(driver);
    }


    public void navigateTabs() throws InterruptedException {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header__toolbar-inner")));
        List<WebElement> allLinks = driver.findElement(By.cssSelector(".header__toolbar ")).findElements(By.tagName("li"));
        int linkCount = 0;
        for (WebElement link : allLinks) {
            String linkText;
            try {
                linkText = link.getText();
                link.click();
            } catch (StaleElementReferenceException E) {
                allLinks = driver.findElement(By.cssSelector(".header__toolbar ")).findElements(By.tagName("li"));
                linkText = allLinks.get(linkCount).getText();
                WebElement childElement;
                WebElement specificWebElement = allLinks.get(linkCount);
                if (specificWebElement.getAttribute("class").contains("desktop-nav__dropdown")) {
                    specificWebElement.click();
                    childElement = specificWebElement.findElement(By.cssSelector(".desktop-nav__dropdown-item-link"));
                    childElement.click();
                } else {
                    allLinks.get(linkCount).click();
                }

            }
            linkCount++;
            switch (linkText) {
                case "Buy":
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Real Estate | Properties for Sale, Rent and Share | Domain"));
                    assertTrue("Not the expected page", getTextFromDropDownList().equalsIgnoreCase(linkText));
                    break;
                case "Rent":
                    assertEquals(driver.getCurrentUrl(), "https://www.domain.com.au/?mode=rent");
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Rent Houses, Apartments, Units, Flats and New Developments | Real Estate | Domain"));
                    assertTrue("Not the expected page", getTextFromDropDownList().equalsIgnoreCase(linkText));
                    break;
                case "New homes":
                    assertEquals(driver.getCurrentUrl(), "https://www.domain.com.au/new-homes");
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("New Homes | Home & Land Packages | Off the Plan Apartments"));
                    String newHomesText = driver.findElement(By.cssSelector(".inner-wrap")).getText();
                    assertThat(newHomesText, containsString("Find New Homes"));
                    break;
                case "Sold":
                    assertEquals(driver.getCurrentUrl(), "https://www.domain.com.au/?mode=sold");
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Sold Houses, Apartments, Units, Flats and New Developments | Real Estate | Domain"));
                    assertTrue("Not the expected page", getTextFromDropDownList().equalsIgnoreCase(linkText));
                    break;
                case "Commercial":
                    assertEquals(driver.getCurrentUrl(), "https://www.commercialrealestate.com.au/");
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Commercial Real Estate and Property For Sale and Lease in Australia | CommercialRealEstate.com.au"));
                    String commercialText = driver.findElement(By.cssSelector(".homepage-tag-line")).getText();
                    assertThat(commercialText, containsString("Australia's leading commercial property site"));
                    navigateBack();
                    break;
                case "News":
                    assertEquals(driver.getCurrentUrl(), "https://www.domain.com.au/news/");
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Real Estate and Property Market News"));
                    navigateBack();
                    break;
                case "Advice":
                    assertEquals(driver.getCurrentUrl(), "https://www.domain.com.au/advice/");
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Real Estate Tips, Guides & Advice"));
                    navigateBack();
                    break;
                case "Agents":
                    assertEquals(driver.getCurrentUrl(), "https://www.domain.com.au/real-estate-agents/");
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Search for real estate agents to sell your property in Australia"));
                    String agentText = driver.findElement(By.cssSelector(".find-an-agent__content")).getText();
                    assertThat(agentText, containsString("Find your local Real Estate Agent"));
                    navigateBack();
                    break;
                case "More":
                    assertEquals(driver.getCurrentUrl(), "https://www.domain.com.au/home?mode=share");
                    new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Share Houses, Apartments, Units, Flats and New Developments | Real Estate | Domain"));
                    navigateBack();
            }
        }
    }


    public void navigateBack() {
        driver.navigate().back();
    }

    public String getTextFromDropDownList() {
        String visibleText = driver.findElement(By.cssSelector(".Select-value")).getText();
        return visibleText;
    }

    public List<String> getPrimaryTabs() {
        List<WebElement> tabElements = getTabElements();
        List<String> primaryTabs = tabElements.stream().map(WebElement::getText).collect(Collectors.toList());
        return primaryTabs;
    }

    private List<WebElement> getTabElements() {
        return driver.findElements(By.cssSelector(".header__toolbar .desktop-nav__menu-option > a"));
    }
}


