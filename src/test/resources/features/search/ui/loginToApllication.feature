Feature: Login To Application

  Scenario: A user login to the profile
    Given open the application
    When user clicked Account
    And user select Login
    Then user is in the loginpage
    When user enter email address as "user@phptravels.com"
    And user enter password as "demouser"
    Then user clicked login button