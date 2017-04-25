Feature: As a user I want to add an inproceedings

  Scenario: user can add an inproceedings with correct required fields
    Given add inproceedings is selected
    When "author" is given
    And "book title" is given
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
    And "" is given
    And "" is given
    And "" is given
    Then inproceedings is added
#
#  Scenario: user cannot add an inproceedings with required fields missing
#    Given add inproceedings is selected
#    When "" is given
#    Then error message is shown
#
#  Scenario: user cannot add invalid values to required fields
#    Given add inproceedings is selected
#    When "author" is given
#    And "title" is given
#    And "booktitle" is given
#    And "invalidvalue" is given
#    Then error message is shown
