Feature: To verify cart quantity after deletion

  Background: User is at the homepage and cart is empty
    Given the user is at the homepage
    And the cart is empty

  @Regression
  Scenario Outline: Deletion of item from cartpage
    Given the user clicks the shopmenu
    When the user adds multiple product to the cart <products>
    And the user clicks the cartmenu
    And the user deletes an item from the cart
    And the user confirms to delete an item
    Then verify the sum of quantity of items in the cart equals the quantity in cartmenu

    Examples: 
      | products                |
      | Teddy Bear,Stuffed Frog |
