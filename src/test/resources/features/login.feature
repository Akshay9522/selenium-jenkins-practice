Feature: SauceDemo login and logout
  @smoke @regression
  Scenario: Valid login
    Given I am on the SauceDemo login page
    When I log in with username "standard_user" and password "secret_sauce"
    Then I should see the Products page

  @regression
  Scenario: Invalid login
    Given I am on the SauceDemo login page
    When I log in with username "invalid_user" and password "wrong_password"
    Then I should see an invalid credentials error

  @regression
  Scenario: Logout
    Given I am on the SauceDemo login page
    When I log in with username "standard_user" and password "secret_sauce"
    Then I should see the Products page
    When I log out
    Then I should return to the login page
