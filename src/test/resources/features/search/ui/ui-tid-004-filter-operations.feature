Feature: Filter Accessories by Brand and Price

  Scenario: Filter accessories by brand
    Given the user is on the accessories page
    When the user selects the brand studio design from the brand filter
    Then only accessories from brand studio design should be displayed

  Scenario: Reset filters using the clear all button
    Given the user has applied brand filter
    When the user clicks the clear all button
    Then all filters should be reset to the default state
    And default accessories should be displayed

