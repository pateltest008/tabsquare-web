Feature: TabSquare Checkout

  Scenario: User is able to checkout successfully
    Given I am on the "login" page
    When I logged in with below detail
    | CountryCode | Number     |
    |     +91     | 9925161706 |
    And I click on login button
    Then I am on the "order-type" page
    And I choose "Dine In" order type
    And I am on the "home" page
    And I add 1st item into cart with 3 quantity
    And I can see 3 quantity in cart
    And I click on the checkout button
    And I am on the "cart" page
    And I select "Pay By Cash" button
    And I am on the "confirm" page
    And I can See order success message "Your Order has been successfully sent to kitchen"
    And I can see generated oder Id