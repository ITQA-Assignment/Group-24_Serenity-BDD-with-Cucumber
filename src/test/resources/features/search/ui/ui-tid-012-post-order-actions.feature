Feature: Post Order Actions

  Scenario: Ensure Orders are Recorded in Order History
    Given user in the user account page knowing the order reference and ordered items
    When user click order history and details card
    Then user navigate to the order history page
    When user can see all the past order reference numbers
    Then user can verify the last order is recorded successfully

  Scenario: Adding a Message for a Placed Order Without Filling the Text Area
    When user click the details link for the referenced order
    Then user navigate to the order details page
    When user select a product within add a message section
    And user click send button
    Then user see the error notification

  Scenario: Adding a Message for a Placed Order by Filling the Text Area
    When user type a message inside the text area within add a message section
    And user click send button
    Then user can verify the message is added successfully

  Scenario: Reordering a Previous Order
    Given user in the user account page knowing the order reference and ordered items
    When user click order history and details card
    And user click the reorder link for the referenced order
    Then user navigate to the checkout page with referenced ordered items
    And user verifies that the same items are displayed

