Feature: As a user I want to add a book

  Scenario: user can add a book with correct required fields
    Given add book is selected
    When "author" is given
    And "publisher" is given
    And "title" is given
    And "2012" is given
    And "" is given
    And "" is given
    And "" is given
    And "" is given
    And "" is given
    And "" is given
    And "" is given
    And "" is given
    Then book is added

#  Scenario: user cannot add a book with required fields missing
#    Given add book is selected
#    When "" is given
#    Then error message is shown
#
#  Scenario: user cannot add invalid values to required fields
#    Given add book is selected
#    When "author" is given
#    And "title" is given
#    And "publisher" is given
#    And "invalidvalue" is given
#    Then error message is shown
