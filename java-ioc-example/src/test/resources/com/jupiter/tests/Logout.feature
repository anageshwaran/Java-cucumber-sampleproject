Feature: Logout validation

  Background: User is at the homepage and the user is not logged in
    Given the user is at the homepage
    And the user is not logged in

  @SmokeTest @Regression
  Scenario: verification of successfull logout
    Given the user clicks the loginlink
    And the user enters the valid login details
    When the user clicks the login button
    And the user clicks the logoutlink
    And the user confirms the logout
    Then verify the user is taken to homepage and usermenu is changed to loginmenu
