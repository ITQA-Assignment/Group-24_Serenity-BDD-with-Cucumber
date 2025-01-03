Feature: User search items

  Scenario: User searches for a keyword that has a semantic meaning and the product is in the shop
    Given User on the homepage
    When User clicks on the search box
    And User searches for "mug" using the search box
    Then User redirects to the search results page
    And User sees search results related to keyword "mug"
    Then User navigates to the homepage


  Scenario: User searches for a keyword that does not have a semantic meaning
    Given User on the homepage
    When User clicks on the search box
    And User searches for "but" using the search box
    Then User redirects to the search results page
    And User sees No matches were found for your search message
    Then User navigates to the homepage


  Scenario: User searches for a keyword that has a semantic meaning but the product is not in the shop
    Given User on the homepage
    When User clicks on the search box
    And User searches for "bread" using the search box
    Then User redirects to the search results page
    And User sees No matches were found for your search message

