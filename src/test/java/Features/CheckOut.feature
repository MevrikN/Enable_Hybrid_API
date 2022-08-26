@smoke @reg @checkout
Feature: Checkout
  Background: Registered user should be able to checkout successfully
  Given User is on homepage
    And User register successfully
    Then click on continue button after successful registration
    Then user should be on Homepage

    Scenario: user can buy a product successfully
      When user click on build your owen computer name
      Then user should be navigated to relevant product page
      And Fill mandatory fields
      And Click add to cart button
      And click on shopping cart button
      Then user can see checkout page
      When user checked Terms and condition box
      And Click on checkout button
      Then user should be navigated to Billing page
      When user enter all billing mandatory information
      And click on continue button on billing page
      Then user should be on Shipping page
      And user can able to select one day delivery
      And user can able to select second day delivery
      When user click on Continue button
      Then user should be navigated to payment selection page
      And user select credit option
      And click on continue button on payment page
      Then user should be on card details page
      When select card type
      And enter card holder name
      And enter card number
      And select expiry month and year
      And enter CVC code
      And click continue button on card details page
      Then user should be navigated to confirm order page
      And user can see email address
      And user click on confirm button
      Then user can see order success message
      And click on continue button on confirmation page

