Feature: Create a book

  Scenario: User creates a book
    Given the base api url for creating a book is set
    When user logs in with username "user" and password "password"
    And user sends a POST request to the endpoint "/api/books" with the payload:
    """
    {
    "id": 54,
    "title": "Reckless4",
    "author": "Lauren Roberts"
    }
    """
    Then the response status code should be 201

