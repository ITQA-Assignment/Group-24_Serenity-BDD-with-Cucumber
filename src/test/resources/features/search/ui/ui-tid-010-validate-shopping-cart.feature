Feature: Add to cart function

  Scenario: Add an item to cart

    Given User should navigate to signal option product page
    And User enter quantity 10
    And User click ADD TO CART button
    And user click  proceed to checkout button
    Then User should navigate to to cart page

    Scenario: Validate Price and Delete in Cart
      Given User should navigate to to cart page
      Then User check total price for item
      And User check total price of all items
      And User increase quantity higher than available quantity
      Then User make quantity to zero
      Then User delete item































