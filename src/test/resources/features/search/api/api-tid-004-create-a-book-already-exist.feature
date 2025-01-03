Feature: Create a book

  Scenario: User created a book
    Given the base api url for create method is set
    When user login with username "user" and password "password" for
    When user creates a book using the index 1
    And user send create request to endpoint "/api/books"
    Then create book response status code should 400

