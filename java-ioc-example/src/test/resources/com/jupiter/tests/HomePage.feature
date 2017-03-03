Feature: Shoppage navigation
  On clicking the 'Start Shopping' button in the homepage, user should be navigated to shoppage

  @SmokeTest @Regression
  Scenario: Shoppage navigation successfull
    Given the user is at the homepage
    When the user clicks the start shopping button
    Then the user should be navigated to the shoppage
