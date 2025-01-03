Feature: User Update A Book

  Scenario: User Update a Book
    Given the base api url for update method is set
    When user logs in with username "user" and password "password"
    And user selects a book to update with the bookid 1, title "Test title", and author "Test author"
    And user sends a PUT request to the endpoint "/api/books"
    Then the response status code should be 403
