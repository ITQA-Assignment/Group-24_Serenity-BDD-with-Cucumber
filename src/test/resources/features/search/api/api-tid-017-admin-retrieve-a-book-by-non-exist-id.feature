Feature: Admin Retrieve a Book with Non-Existent ID
  Scenario: Admin Attempts to Retrieve a Non-Existent Book
    Given the user base url for get one book is set
    When user login with username "admin" and password "password" for get only a book
    When user select a book to retrieve using the non exist id -1
    And user send get request to the endpoint "/api/books" to get the book
    Then the response code for user retrieve the selected book should 404
    And user should see an error message indicating the book was not found
