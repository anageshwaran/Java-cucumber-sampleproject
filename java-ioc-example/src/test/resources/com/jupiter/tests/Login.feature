Feature: Login screen validation

  Background: User is at the homepage and the user is not logged in
    Given the user is at the homepage
    And the user is not logged in

  @Regression
  Scenario: Verify invalid login message 
    Given the user clicks the loginlink
    And the user enters the invalid login details
    When the user clicks the login button
    Then the user should be prompted with proper error message

  @SmokeTest @Regression 
  Scenario: Verify successfull submission
    Given the user clicks the loginlink
    And the user enters the valid login details
    When the user clicks the login button
    Then the username should be displayed on successfull login
