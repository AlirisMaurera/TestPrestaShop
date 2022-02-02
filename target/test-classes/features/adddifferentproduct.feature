Feature: Add different products to the cart and check that the cart has the quantity added


  Scenario: Add different product to the cart
    Given a user loged with email and password:
      | email                   | password |
      | alirismaurera@gmail.com | 123456   |
    When add quantity of the product:
      | quantity | product | size | color | dimension | productname            |
      | 2        | 0       | L    | White |           |                        |
      | 2        | 2       |      |       | 40x60cm   | Add_Different_products |
    Then check that the cart has the quantity added 4
