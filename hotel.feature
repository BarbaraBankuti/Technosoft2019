@web @regression @hotels

Feature: Hotels Deal Of Day price check

    Background:
      Given I am on hotel main page

  @hotel-1
  Scenario: Deal of day
    When I set destination
    And I click on search
    Then I check if Deal Of The Day is less than 200

   @hotel-2
   Scenario: Star check
     When I set destination2
     And I click on search2
     Then I set starts
     And I check the stars of hotels displayed

  @hotel-3
  Scenario Outline: Room Check
    When I click on room dropdown and select <room>
    Then I check room drop downs <roomDropDownChoice>

    Examples:
      | room | roomDropDownChoice |
      | 1    | 3           |
      | 2    | 5           |
      | 3    | 7           |
      | 4    | 9           |
      | 5    | 11          |
      | 6    | 13          |
      | 7    | 15          |
      | 8    | 17          |
      | 9+   |  0          |

