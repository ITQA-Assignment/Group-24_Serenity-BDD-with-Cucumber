Feature: Add to cart function

  Scenario: Add item to cart

    Given User click "Hummingbird printed t-shirt"
    Then User should navigate to signal option product page
    When User select size "S"
    And User click color "Black"
    And User enter quantity 300
    And User click ADD TO CART button
    And User click Continue shopping button
    Then User should navigate to signal option product page
    And User click the home tab
    Then User select new item
    And User enter new quantity 10
    And User click ADD TO CART button
    Then System should display "Product successfully added to your shopping cart"
    And user click  proceed to checkout button
    Then User should navigate to to cart page















