Feature: Filter Accessories by Brand

  Scenario: Filter accessories by brand
    Given the user is on the accessories page
    When the user selects the brand "Studio Design" from the brand filter
    Then only accessories from brand "Studio Design" should be displayed



