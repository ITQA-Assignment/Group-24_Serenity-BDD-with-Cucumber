Feature: Add to cart function

  Scenario: Add an item to cart with less than available

    Given User click the home tab
    When User click "Hummingbird printed t-shirt"
    Then User should navigate to signal option product page
    And User enter quantity 100
    And User click ADD TO CART button
    Then System should display "Product successfully added to your shopping cart"
    And user click  proceed to checkout button
    Then User should navigate to to cart page

    Scenario: Add an item to cart with greater than quantity
    Given User click the home tab
    Then User select new item
    And User enter new quantity 3000
    And User click ADD TO CART button
    Then System should display "There are not enough products in stock"
    And User should navigate to signal option product page

    Scenario: Add an item to cart with same as available
      Given User click the home tab
      Then User select new item
      And User enter new quantity 300
      And User click ADD TO CART button
      Then System should display "Product successfully added to your shopping cart"
      And User click Continue shopping button
      And user click  proceed to checkout button
      Then User should navigate to to cart page

















