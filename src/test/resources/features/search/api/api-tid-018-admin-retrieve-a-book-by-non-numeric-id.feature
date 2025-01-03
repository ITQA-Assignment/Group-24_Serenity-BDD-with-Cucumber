Feature: Admin Retrieve a Book with Non-Numeric ID
  Scenario: Admin Attempts to Retrieve a Book with Non-Numeric ID
    Given the user base url for get a book is set
    When admin login with username "admin" and password "password" for get only a book
    When user select a book to retrieve using the non numeric id "abc"
    And user send the get request to the endpoint "/api/books"
    Then the status code for user retrieve the chosen book should 400

