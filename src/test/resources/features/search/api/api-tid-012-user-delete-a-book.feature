Feature: User Delete A Book

  Scenario: User delete a book
    Given the user base api url for delete method is set
    When user login with username "user" & password "password"
    When user select a book to delete with the index 1
    And user send delete request to the endpoint "/api/books"
    Then the response status code for user should 403