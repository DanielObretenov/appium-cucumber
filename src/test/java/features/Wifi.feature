Feature: Wifi
  Scenario turn on wifi:
    When I enable the wifi option
    And I enter wifi setting "myWifi"
    Then I should have connected to wifi