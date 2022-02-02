Feature: Remove products from the cart

  Background:
    Given a user loged with valid email password:
      | email                   | password |
      | alirismaurera@gmail.com | 123456   |


  Scenario: remove all the products from the cart and the cart must be zero
    And a product in the cart:
      | quantity | product | size | color | dimension |
      | 3        | 5       |      |       |           |
    When deleted a product from the cart 'Remove'
    Then the cart is 0
    And show a message 'There are no more items in your cart'


  Scenario: remove a product of the list
    And a product in the cart:
      | quantity | product | size | color | dimension |
      | 3        | 5       |      |       |           |
      | 2        | 0       | M    | Black |           |
    When deleted the first product of the list 'Remove_first'
    Then the cart is 2

