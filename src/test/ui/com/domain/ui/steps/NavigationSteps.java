package com.domain.ui.steps;

import com.domain.ui.pages.HomePage;
import com.domain.ui.pages.MegaMenuPage;
import com.domain.ui.utility.config.ResourceManager;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

@Slf4j
public class NavigationSteps extends BaseSteps {

    private String homepage_url = resourceManager.getUrl("homepage_url");
    private MegaMenuPage megaMenuPage = new MegaMenuPage(driver);


    public NavigationSteps(ResourceManager resourceManager) {
        super(resourceManager);
    }


    @Given("^I am in Domain homepage$")
    public HomePage i_Am_In_Domain_Homepage() throws Throwable {
        driver.get(homepage_url);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        HomePage homepage = new HomePage(driver);
        homepage.assertPage();
        return homepage;
    }


    @When("^I navigate through the tabs successfully$")
    public void i_Navigate_Through_The_Tabs_Successfully() throws Throwable {
        megaMenuPage.navigateTabs();
    }

    @Then("^I should see all the menu options available$")
    public void i_Should_See_All_The_Menu_Options_Available(DataTable primaryTabs) throws Throwable {
        List<String> tabs = primaryTabs.topCells();
        for (String tab : tabs) {
            assertThat(megaMenuPage.getPrimaryTabs(), hasItems(tab));
        }

    }
}
