Feature: User Sign In


  Scenario: Sign In with the Valid Credentials
    Given user in the homepage
    When user click sign in tab
    Then user should navigate to sign in page
    When user enter email "pub@prestashop.com"
    And user enter password "123456789"
    And user click sign in button
    Then user login to the application