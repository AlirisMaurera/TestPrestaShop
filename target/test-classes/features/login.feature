Feature: Do Login

  Background:
    Given a user is in the page prestashop
    When click in sign in

  Scenario Outline: Do login with valid data
    And fill email '<email>' password '<password>' '<nameScreenShot>'
    Then should to do login and show the name '<name>' in the page

    Examples:
      | email                   | password | name           | nameScreenShot |
      | alirismaurera@gmail.com | 123456   | Aliris Maurera | Login-positive |


  Scenario Outline: Login with empty email or password field
    And fill email '<email>' password '<password>' '<nameScreenShot>'
    Then it should stay on the same page

    Examples:
      | email                   | password | nameScreenShot       | #
      |                         | 123456   | Login-email-empty    | #email empty
      | alirismaurera@gmail.com |          | Login-password-empty | #password empty
      |                         |          | Login-fields-empty   | # both fields empty


  Scenario Outline: Login with invalid email or password
    And fill email '<email>' password '<password>' '<nameScreenShot>'
    Then it should stay on the same page
    Then show a message '<message>' of  failed login

    Examples:
      | email                   | password | message                | nameScreenShot           | #
      | aliris@gmail.com        | 123456   | Authentication failed. | Login-email-invalid      | # invalid email
      | alirismaurera@gmail.com | 123489   | Authentication failed. | Login-password-invalid   | # invalid password
      | aliris@gmail.com        | 123489   | Authentication failed. | Login-pass-email-invalid | # invalid email and password