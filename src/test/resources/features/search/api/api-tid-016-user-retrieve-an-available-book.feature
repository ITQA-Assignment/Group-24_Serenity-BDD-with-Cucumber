Feature: User Retrieve an Available Book

  Scenario: User Retrieve Only One Available Book
    Given the user base api url for get a book is set
    When user login with username "user" and password "password" for get a book
    When user choose a book to retrieve using the available index 2
    And user send get request to the endpoint "/api/books"
    Then the status code for user retrieve the selected book should 200
    And user retrieve the selected book