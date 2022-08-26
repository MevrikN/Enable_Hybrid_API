@reg @smoke @registration
Feature: registration

  Background: User is on Registration page
    And click on Registration tab


  @reg
  Scenario Outline: User should able to register successfully when enters all required fields in valid format.
    When user click on male radio button
    And enter firstname as "<firstname>"
    And enter lastname as "<lastname>"
    And enter email address first part as "<email>"
    And enter password as "<password>"
    And enter conform password as "<conform_password>"
    And Click on Register button
    Then user can see success message
    And click on continue button
    Examples:
      | firstname | lastname | email  | password | conform_password |
      | Raj       | Patel    | raj001 | asd@123  | asd@123          |
      | 0k*4       | PG&3    | raj001 | asd@123  | asd@123          |



  @reg
  Scenario Outline: User should see error message when enter email address in invalid format.
    Given User is on Registration page
    When user click on male radio button
    And enter firstname as "<firstname>"
    And enter lastname as "<lastname>"
    And enter email address first part as "<email>"
    Examples:
      | firstname | lastname | email   |
      | 0012cvb   | 09@abc   | raj001@ |
