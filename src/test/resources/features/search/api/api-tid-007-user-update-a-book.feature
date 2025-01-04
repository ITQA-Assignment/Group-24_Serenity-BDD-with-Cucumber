Feature: User Update A Book

  Scenario: User Update a Book
    Given set the base api url for update method
    When user logs in with username "user" and password "password"
    And user selects a book to update with the bookid 2, title "Test title", and author "Test author"
    And user sends a put request to the url "/api/books"
    Then the expected response status code should be 403