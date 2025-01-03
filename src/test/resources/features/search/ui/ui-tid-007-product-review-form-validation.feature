Feature: Product Review Form Validation

  Scenario: Verify Product Review Cannot Be Submitted When Title and Review Fields Are Empty
    Given user is on the product page
    When user clicks write your review button
    And user leaves both title and review fields blank
    And user clicks send button
    Then title and review fields are highlighted in red

  Scenario: Verify Product Review Cannot Be Submitted When Title or Review Field Is Empty
    Given user is on write your review modal
    And user fills the title field but leaves the review field blank
    And user clicks send button
    Then review field is highlighted in red

    When user fills the review field but leaves the title field blank
    And user clicks send button
    Then title field is highlighted in red

  Scenario: Verify Successful Product Review Submission When Both Title and Review Fields Are Filled
    Given user is on write your review modal
    And user fills both the title and review fields
    And user clicks send button
    Then review sent message is displayed
    And user clicks ok button to close the review sent message


