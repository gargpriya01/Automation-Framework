Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given user is on login page
    When user enters username "testuser" and password "password123"
    And clicks on login button
    Then user should be navigated to home page
