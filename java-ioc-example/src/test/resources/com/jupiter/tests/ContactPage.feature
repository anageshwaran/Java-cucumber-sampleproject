Feature: Submission of contact details

  Background: User is at the homepage
    Given the user is at the homepage

  @SmokeTest @Regression
  Scenario: Successfull submission of contact details
    Given the user clicks the contact menu
    And the user enters the valid contact details
    When the user clicks the submit button
    Then the user should be prompted with thank you message

  @Regression
  Scenario: Verification of error message on unsuccessfull submission
    Given the user clicks the contact menu
    And the user enters the invalid contact details
    When the user clicks the submit button
    Then the user should be prompted with appropriate error message
