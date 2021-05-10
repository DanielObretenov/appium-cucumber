@DragTests

Feature: Drag element
  Scenario: Dragging one element
    Given I am on the dragging page
    When I drag from 1 to 2
    Then  The element should be dragged