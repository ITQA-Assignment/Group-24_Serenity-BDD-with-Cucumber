#Feature: Verify stock count updates correctly for in-stock products
#
#  Scenario: Verify that stock count updates correctly for in-stock products
#    Given user navigates to the Home Accessories section
#    And user records the initial in-stock product count
#    When user clicks on the item "Mug The Adventure Begins", sets the maximum quantity, and clicks "Add to Cart"
#    And clicks "Continue Shopping"
#    And user navigates to the Home Accessories section
#    And user records the current in-stock product count
#    Then user verifies that the number of in-stock items has decreased by one
