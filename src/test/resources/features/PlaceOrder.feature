Feature: Place Order

Background:  User Login
Given User is on login page
When user enters "standard_user" and "secret_sauce"
Then User should be on Home page

Scenario: Add Item to Cart
Given User should be on Home page
When User add item to cart
Then Item must be added

Scenario: checkout order
Given User is on Cart page
When User do checkout
Then Should navigate to checkout page