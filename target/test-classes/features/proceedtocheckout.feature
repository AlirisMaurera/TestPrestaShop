Feature: Proceed to checkout of the product

  Background:
    Given a user with a email and password valid:
      | email                   | password |
      | alirismaurera@gmail.com | 123456   |


  Scenario Outline: Checkout of a product
    And a product in the cart '<index>' '<size>' '<color>' <quantity> '<dimension>'
    When proceed to checkout
    And add addrese, a shipping method
    And select payment method <option> '<nameTest>'
    Then show a summary of the order '<NameProduct>' '<price>' '<Total>' '<TotalwithTax>'
    And a message of confirmation 'YOUR ORDER IS CONFIRMED'


    Examples:
      | index | size | color | quantity | dimension | option | NameProduct                 | price  | Total   | TotalwithTax | nameTest  |
      | 0     | M    | Black | 2        |           | 1      | Hummingbird printed t-shirt | $19.12 | $38.24  | $45.24       | checkout1 |
      | 2     |      |       | 4        | 60x90cm   | 2      | Framed poster               | $49.00 | $196.00 | $203.00      | checkout2 |


