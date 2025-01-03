Feature: Create a book already exist

  Scenario: User created a book exist
    Given the base api url for create method is set
    When user login as username "user" and password "password"
    When user creates a book using the index 1
    And user send create request to endpoint "/api/books"
    Then create book response status code should 208


