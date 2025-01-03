Feature: Admin and user login with mix letters


  Scenario: User logs in with a valid username in mix case letters
    Given the base API URL for login is set
    When the user logs in with username "UsER" and password "password"
    And user send a request to the endpoint "/api/books" and "payload"
    Then the response status code is 401



  Scenario: Admin logs in with a valid username in mix case letters
    Given the base API URL for login is set
    When the admin logs in with username "AdMiN" and password "password"
    And admin send a request to the endpoint "/api/books" and "payload"
    Then the response status code is 401



