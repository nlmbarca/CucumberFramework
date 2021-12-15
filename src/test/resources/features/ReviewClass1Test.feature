Feature: Login functionality
  Background:
    Given user is able to login with valid admin credentials
    When user clicks on login button

  @review
  Scenario: Test scenario for dashboard verification functionality
    Then user verify dashboard page

  @review
  Scenario: Test scenario for add employee functionality
    When user clicks on PIM option and Add Employee option
    Then user is navigated to add employee page