Feature: Login
  Scenario: Login eith etsy credentials
    Given user click on get started button
    When user logs in with etsy credentials
    Then user verifies that etsy logo is displayed