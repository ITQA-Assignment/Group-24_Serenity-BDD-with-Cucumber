Feature: Create a book missing all mandatory filed

  Scenario: User created a book missing all mandatory filed

    Given the base api url for create method is set missing all mandatory filed
    When user login as username "user" and password "password" missing all mandatory filed
    When user creates a book using the index 1 missing all mandatory filed
    And user send create request to endpoint "/api/books" missing all mandatory filed
    Then create book response status code should 400 missing all mandatory filed