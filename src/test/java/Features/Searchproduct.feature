@smoke @reg @search
Feature: Search products by name
  Scenario Outline: Search product directly from homepage
    Given user is on homepage to search products
    When user type keyword as "<keyword>"
    And click on search button
    Then user should be able to see relevant product name containing "<keyword>"
    Examples:
      | keyword |
      | Nike    |
      | adidas  |