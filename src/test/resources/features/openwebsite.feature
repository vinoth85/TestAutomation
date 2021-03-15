@website
Feature: Navigate through the tabs and validate user landed on the correct page

  As a cba User
  I want to navigate through all the tabs available in the homepage
  so that I can view details about each tab

  **DIDNT  FIND THE NAVIGATION TO TRAVEL MONEY OVERSEAS IN COMMBANK APP. HENCE THE BANKING LINK IS TAKEN AS EXAMPLE AND SCRIPTED***

  Background:
    Given I am in "website" homepage

  Scenario: Verify all the tabs in the header navigates to the correct page
    And I should see all the menu options available for "website"
      | Banking | Home loans | Insurance | Investing & super |
    When i navigate to "Banking" section
    Then I should see all the menu options available for "Banking"
      | Everyday accounts | Savings accounts & Term Deposits | Credit cards | Personal loans | Personal Overdrafts| International payments| Premier & Private|
    And I logon to commbank
    And I validate the login screen appears



