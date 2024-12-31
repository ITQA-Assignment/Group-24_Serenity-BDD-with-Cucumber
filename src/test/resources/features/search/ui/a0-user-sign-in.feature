Feature: User sign in

  Scenario: Sign in with the valid credentials
    Given User in the homepage
    When User click sign in tab
    Then User should navigate to sign in page
    When User enter email "pub@prestashop.com"
    And User enter password "123456789"
    And User click sign in button
    Then User login to the application