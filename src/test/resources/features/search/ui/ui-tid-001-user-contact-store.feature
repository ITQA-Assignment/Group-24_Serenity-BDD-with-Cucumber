Feature: User contact store

  Scenario: User submits the form without entering a message
    Given User on the homepage
    When User clicks on the contact us section
    Then User should navigate to contact us page
    When User leaves the message field empty
    And User clicks the send button
    Then User should see an error message indicating that the message field is required

  Scenario: User contacts the store through the "Contact Us" form
    Given User on the contact us page
    When User clicks on the contact us section
    Then User should navigate to contact us page
    When User types a message in the form
    And User clicks the send button
    Then User should see a confirmation that the form was successfully submitted

