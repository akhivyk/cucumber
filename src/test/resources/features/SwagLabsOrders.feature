Feature: Placing an order on Saucedemo website

  Scenario: Placing an order with user credentials from the database
    Given I am logged in with user credentials from the database
    When I add the orders stored in the database for the mentioned user
    And I proceed to checkout
    Then the ordering should be successful