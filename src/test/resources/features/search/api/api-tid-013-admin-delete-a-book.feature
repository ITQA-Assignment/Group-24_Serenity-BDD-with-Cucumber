Feature: Admin Delete A Book

  Scenario: Admin delete a book
    Given the base api url for delete method is set
    When user login with username "admin" and password "password"
    When user select a book to delete using the index 1
    And user send delete request to endpoint "/api/books"
    Then the response status code should 200