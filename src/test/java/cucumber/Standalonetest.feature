@tag
Feature: Purchase an order from ecommerce website  

Background:
    Given I landed on ecommerce website 

@tag2
Scenario Outline: Positive test of submitting the order 
    Given Login with username <username> and password <password>
    When I add product <productName> to cart 
    And Checkout the product <productName> and submit the order
    Then I verify the confirmation message "THANKYOU FOR THE ORDER." is displayed

Examples:
    | username             | password   | productName       |
    | ajay25781@gmail.com  | Aju25781@25| ZARA COAT 3       |