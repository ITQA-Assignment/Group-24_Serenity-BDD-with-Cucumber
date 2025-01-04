Feature: Admin and user login with invalid credentials


  Scenario: User logs in with an invalid username
    Given the base API URL for login invalid is set
    When the user logs in with invalid username "girl" and password "abc"
    And user send a login request to the endpoint "/api/books" and "payload"
    Then the response status code will be 401



  Scenario: Admin logs in with an valid username in mix case letters
    Given the base API URL for login invalid is set
    When  admin logs in with invalid username "boy" and password "def"
    And the admin send a login request to the endpoint "/api/books" and "payload"
    Then the response status code will be 401
