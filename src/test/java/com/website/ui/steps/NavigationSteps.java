package com.website.ui.steps;

import com.website.ui.pages.HomePage;
import com.website.ui.pages.MegaMenuPage;
import com.website.ui.utility.config.ResourceManager;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class NavigationSteps extends BaseSteps {

    private String homepage_url = resourceManager.getUrl("homepage_url");
    private String website_url = resourceManager.getUrl("website_url");
    private MegaMenuPage megaMenuPage = new MegaMenuPage(driver);


    public NavigationSteps(ResourceManager resourceManager) {
        super(resourceManager);
    }


    @Given("^I am in \"([^\"]*)\" homepage$")
    public HomePage i_Am_In_Website_Homepage(String website) throws Throwable {


        driver.get(website_url);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        HomePage homepage = new HomePage(driver);
        homepage.assertPage(website);
        return homepage;
    }


    @When("^I navigate through the tabs successfully$")
    public void i_Navigate_Through_The_Tabs_Successfully() throws Throwable {
        megaMenuPage.navigateTabsForWebsite();
    }

    @Then("^I should see all the menu options available for \"([^\"]*)\"$")
    public void i_Should_See_All_The_Menu_Options_Available(String text,DataTable primaryTabs) throws Throwable {
        Thread.sleep(5000);
        switch(text){
            case "website":
            List<String> tabs = primaryTabs.topCells();
            for (String tab : tabs) {
                assertThat(megaMenuPage.getPrimaryTabs(text), hasItems(tab));
            }
            break;
            case "Banking":
                List<String> subTopics = primaryTabs.topCells();
                for (String subTopic : subTopics) {
                    assertThat(megaMenuPage.getPrimaryTabs(text), hasItems(subTopic));
                }
        }


    }

    @When("^i navigate to \"([^\"]*)\" section$")
    public void iNavigateToSection(String text) throws Throwable {
        megaMenuPage.getBankingElement().click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Banking - CommBank"));
    }
}
