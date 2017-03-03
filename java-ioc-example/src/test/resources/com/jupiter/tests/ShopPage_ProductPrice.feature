Feature: Verify product price
  To verify the price of the product in the shop page

  Background: User is at the homepage
    Given the user is at the homepage

  @SmokeTest @Regression
  Scenario Outline: To verify the price of the product
    Given the user clicks the shopmenu
    Then verifies the price <price> for the product <product>

    Examples: 
      | product      | price  |
      | Teddy Bear   | $12.99 |
      | Stuffed Frog | $10.99 |
