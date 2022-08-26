@smoke @reg @addtocart
Feature: Add to Cart
  Checking that add to cart functionality is working or not.

  Scenario: Add product to cart
    Given user is on home page
    When user click on Build your own computer product name
    Then user should be navigate to product details page
    And select all mandatory option
    And click on Add to cart button
    Then user should see success message on screen
