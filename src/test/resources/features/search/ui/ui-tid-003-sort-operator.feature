Feature: Sort Accessories by Name

  Scenario: Verify that a user can sort accessories by alphabetical order
    Given verify user in the homepage
    When the user clicks on the accessories section
    Then user should navigate to accessories page
    When user clicks on the sort by dropdown
    And the user selects Name, A to Z option from the sort by dropdown
    Then the accessories should be sorted in alphabetical order

