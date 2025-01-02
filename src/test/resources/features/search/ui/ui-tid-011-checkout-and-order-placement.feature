Feature: Checkout and Order Placement

  Scenario: Successful Navigation to Checkout
    Given user is on the shopping cart page
    When user click the proceed to checkout button
    Then user navigate to the checkout page

  Scenario: Total Price Update Based on Delivery Method
    Given personal information section is auto completed
    When user select a predefined address
    And user select a shipping method
    Then total price update with the shipping cost

  Scenario: Enforcing Terms of Service Agreement
    When user select a payment option
    And user verify the agreement is unchecked
    Then place order button is disabled
    When user check the agreement
    Then place order button is enabled

  Scenario: Successful Order Placement
    When user click the place order button
    Then user navigate to the order confirmation page
    And user see the order reference and ordered items


