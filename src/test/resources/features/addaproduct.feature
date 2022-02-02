Feature: Add a product to the cart


  Scenario Outline: Add a product to the cart
    Given a user do loged with valid email '<email>' and password '<password>'
    When Select the product number '<index>'
    And define the characteristics of the product '<size>' '<color>' <quantity> '<dimension>'
    And Add to cart '<nameTest>'
    Then show a summary with product name '<productname>' price '<price>' SubTotal '<subtotal>' shipping '<shipping>' total with taxes included '<taxIncl>' '<taxes>'
    And a message 'Product successfully added to your shopping cart'

    Examples:
      | email                   | password | index | size | color | quantity | dimension | productname                 | price  | subtotal | shipping | taxIncl | taxes | nameTest     |
      | alirismaurera@gmail.com | 123456   | 0     | M    | Black | 2        |           | Hummingbird printed t-shirt | $19.12 | $38.24   | $7.00    | $45.24  | $0.00 | Add_Product1 |
      | alirismaurera@gmail.com | 123456   | 1     | L    | Black | 3        |           | Hummingbird printed sweater | $28.72 | $86.16   | $7.00    | $93.16  | $0.00 | Add_Product2 |
      | alirismaurera@gmail.com | 123456   | 2     |      |       | 2        | 60x90cm   | Framed poster               | $49.00 | $98.00   | $7.00    | $105.00 | $0.00 | Add_Product3 |
      | alirismaurera@gmail.com | 123456   | 5     |      |       | 2        |           | Mug The best is yet to come | $11.90 | $23.80   | $7.00    | $30.80  | $0.00 | Add_Product4 |

