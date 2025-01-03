Feature: Admin Update A Book Without Author And Title

  Scenario Outline: Admin updates a book without a mandatory field
    Given base api url for put method is set
    When admin login with the username "admin" and password "password"
    When admin select a book to put with index 3
    And admin sets the request body without field "<missingField>"
    And admin send a put request to endpoint "/api/books"
    Then admin response status code should 400

    Examples:
      | missingField |
      | author       |
      | title        |
