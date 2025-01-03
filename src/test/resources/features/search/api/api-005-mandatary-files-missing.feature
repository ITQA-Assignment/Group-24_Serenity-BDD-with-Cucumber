Feature: Create a book without mandatory filed missing

  Scenario: User created a book without author

    Given the base api url for create method is set for post
    When user login as username "user" and password "password" for post
    When user creates a book using the index 1 for post
    And user send create request to endpoint "/api/books" without author
    Then create book response status code should 400 invalid input without author

  Scenario: User created a book without title

    Given the base api url for create method
    When user login as username  "user" and "password" for create method
    When user creates a book using the index 1 for create book
    And user send create request to endpoint "/api/books" without title
    Then create book response status code should 400 invalid input without title