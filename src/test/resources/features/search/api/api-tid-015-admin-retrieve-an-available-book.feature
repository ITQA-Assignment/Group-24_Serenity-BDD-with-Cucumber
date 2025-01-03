Feature: Admin Retrieve an Available Book

  Scenario: Admin Retrieve Only One Available Book
    Given the user base api url for get one book is set
    When user login with username "admin" and password "password" for get only one book
    When user select a book to retrieve using the available index 6
    And user send get request to the endpoint "/api/books" to get the selected book
    Then the response status code for user retrieve the selected book should 200
    And user can retrieve the selected book