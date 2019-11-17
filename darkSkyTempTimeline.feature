@web @regression @temp

Feature: Darksky Temperature Timeline Test

    Given I am on main page

  @temp-1
  Scenario: Verify Temperature Timeline Min/Max is the same
    When I scroll down
    Then I click on extend Timeline

  @temp-2
  Scenario: Verify hour incrementation in timeline
    Then I check if hours incremented by two


