Feature: Verification of cart count in the cartmenu
  The quantity displayed in the cart menu should be equal to the items added to the cart

  Background: User is at the homepage and cart is empty
    Given the user is at the homepage
    And the cart is empty

  @SmokeTest @Regression
  Scenario Outline: Adding single item to the cart
    Given the user clicks the shopmenu
    When the user adds product to the cart <product>
    Then verify the cart count updated to quantity <quantity>

    Examples: 
      | product    | quantity |
      | Teddy Bear |        1 |

  @Regression
  Scenario Outline: Adding single item to the cart multiple times
    Given the user clicks the shopmenu
    When the user adds product <product> to the cart multiple times <count>
    Then verify the cart count updated to quantity <quantity>

    Examples: 
      | product    | count | quantity |
      | Teddy Bear |     3 |        3 |

  @Regression
  Scenario Outline: Adding multiple items to the cart
    Given the user clicks the shopmenu
    When the user adds multiple product to the cart <products>
    Then verify the cart count updated to quantity <quantity>

    Examples: 
      | products                | quantity |
      | Teddy Bear,Stuffed Frog |        2 |
