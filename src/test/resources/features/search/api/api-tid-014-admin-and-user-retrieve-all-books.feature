Feature: Admin and User Retrieve All Books

  Scenario: Admin Retrieve All Books
    Given the user base api url for get all books is set
    When user login with username "admin" and password "password" for get all books
    And user send get all request to the endpoint "/api/books"
    Then the response status code for user get all books should 200
    And user can see all the available books list

  Scenario: User Retrieve All Books
    Given the user base api url for get all books is set
    When user login with username "user" and password "password" for get all books
    And user send get all request to the endpoint "/api/books"
    Then the response status code for user get all books should 200
    And user can see all the available books list