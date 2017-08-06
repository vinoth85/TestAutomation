@search
Feature: Search about Health Direct schemes available

  As a Health Direct User
  I want to search for the health direct schemes available
  so that I can avail the suitable scheme

  Background:
    Given I am in Health direct homepage

  Scenario Outline: Search for a text in the homepage
    When I search for "<searchText>" in the header and select "<selectText>"
    Then I see the details about the "<validateText>"

    Examples:
      | searchText       | selectText               | validateText             |
      | Health Insurance | Health Insurance Schemes | Private Health Insurance |