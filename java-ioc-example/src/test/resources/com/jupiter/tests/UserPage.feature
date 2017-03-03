Feature: User page validation

  Background: User is at the homepage and the user is not logged in
    Given the user is at the homepage
    And the user is not logged in

  @Regression
  Scenario: Verify welcome message
    Given the user clicks the loginlink
    And the user enters the valid login details
    When the user clicks the login button
    And the user clicks the userlink
    Then verify the welcome message
