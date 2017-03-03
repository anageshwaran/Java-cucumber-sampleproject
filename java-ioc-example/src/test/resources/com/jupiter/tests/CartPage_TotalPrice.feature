Feature: Total price verification in cartpage
  To verify the sum of subtotal of items in the cart equals the total price

  Background: User is at the homepage and cart is empty
    Given the user is at the homepage
    And the cart is empty

  @SmokeTest @Regression
  Scenario Outline: Verification of total price displayed
    Given the user clicks the shopmenu
    When the user adds multiple product to the cart <products>
    And the user clicks the cartmenu
    Then verify the sum of subtotal of items in the cart equals the total

    Examples: 
      | products                |
      | Teddy Bear,Stuffed Frog |
