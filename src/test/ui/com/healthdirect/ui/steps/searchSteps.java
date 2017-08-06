package com.healthdirect.ui.steps;

import com.healthdirect.ui.pages.HomePage;
import com.healthdirect.ui.pages.SearchPage;
import com.healthdirect.ui.utility.config.ResourceManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchSteps extends BaseSteps {

    private String homepage_url = resourceManager.getUrl("homepage_url");
    private HomePage homePage = new HomePage(driver);
    private SearchPage searchPage = new SearchPage(driver);


    public SearchSteps(ResourceManager resourceManager) {
        super(resourceManager);
    }


    @Given("^I am in Health direct homepage$")
    public HomePage I_am_in_Health_direct_homepage() throws Throwable {
        driver.get(homepage_url);
        HomePage homepage = new HomePage(driver);
        homepage.assertPage();
        return homepage;
    }

    @When("^I search for \"([^\"]*)\" in the header and select \"([^\"]*)\"$")
    public void I_search_for_schemes_in_the_header(String searchText, String selectValue) throws Throwable {
        homePage.selectSearchText(searchText, selectValue);
        // homePage.clickSearch();
    }

    @Then("^I see the details about the \"([^\"]*)\"$")
    public void I_see_the_details_about_the_scheme(String searchResult) throws Throwable {
        searchPage.assertPage();
        searchPage.validateResults(searchResult);

    }


}
