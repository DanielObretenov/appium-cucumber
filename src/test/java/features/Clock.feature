@ClockTests
Feature: Clock


  Scenario: set clock
    Given I am on the clock screen
    When I set the clock to "9:15"
    Then I should see the new time set
