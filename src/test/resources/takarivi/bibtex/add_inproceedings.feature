Feature: As a user I want to add a inproceedings

  Scenario: user can add a inproceedings with correct required fields
    Given add inproceedings is selected
    When valid inproceedings data is given
    Then a list of references is showed

Scenario: user can not add a inproceedings with incorrect required fields
    Given add inproceedings is selected
    When invalid inproceedings data is given
    Then a prompt is showed