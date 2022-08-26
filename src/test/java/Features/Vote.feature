@vote @reg
Feature: User should be able give vote
  Scenario: user can not able to give their vote without account
    Given user is on home page for give a vote
    When user click on vote button by select any category
    Then user can see Error message

    Scenario: user can not able to give vote without selecting a radio button
      Given user is on homepage
      When user click on vote button without selecting radio button
      Then popup window will show the error message
      And click ok to comeback on homepage

      Scenario: Registered users can give their vote
        Given user is logged in and is on homepage
        When user click on poor radio button
        And click on vote button
        Then user can see success message of vote