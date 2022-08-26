Feature: Add to cart functionality

Scenario Outline: Add items to the card

Given user navigates to login page
  When user enters <username> and <password>
  And clicks log in
  And selects an item and add it to cart
  Then user goes to the cart and verifies that the item is added

  Examples:
   | username        | password |
   | standard_user   | secret_sauce |


