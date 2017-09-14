@navigation
Feature: Navigate through the tabs and validate user landed on the correct page

  As a Domain User
  I want to navigate through all the tabs available in the homepage
  so that I can view details about each tab

  Background:
    Given I am in Domain homepage

  Scenario: Verify all the tabs in the header navigates to the correct page
    Then I should see all the menu options available
      | Buy | Rent | New homes | Sold | Commercial | News | Advice | Agents | More |
    And I navigate through the tabs successfully