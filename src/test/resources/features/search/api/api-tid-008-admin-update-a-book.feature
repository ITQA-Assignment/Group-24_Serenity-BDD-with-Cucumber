Feature: Admin Update A Book

  Scenario: Admin Update a Book
    Given the base api url for update method is set
    When admin authenticates with username "admin" and password "password"
    And admin selects a book to update with the bookid 3, title "New title", and author "New author"
    And admin sends a put request to update a book to the endpoint "/api/books"
    Then admin gets response status code should 200
