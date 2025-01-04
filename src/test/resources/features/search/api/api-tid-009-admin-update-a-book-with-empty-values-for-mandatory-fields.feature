Feature: Admin Update A Book With Empty Values For Mandatory Fields

  Scenario: Admin Update a Book with Empty Values for Mandatory Fields
    Given the base api url for put method is set
    When admin logs in to the system with the username "admin" and password "password"
    And admin selects a book to update with the empty values for bookid 2, title "", and author ""
    And admin sends a put request to update a book to the end url "/api/books"
    Then the received response status code should be 400