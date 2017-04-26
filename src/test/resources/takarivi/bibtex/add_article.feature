Feature: As a user I want to add an article

  Scenario: user can add an article with correct required fields
    Given add article is selected
    When valid article data is given
    Then a list of references is showed

Scenario: user can not add an article with incorrect required fields
    Given add article is selected
    When invalid article data is given
    Then a prompt is showed

Scenario: user can remove an article
    Given article is added
    When the reference is selected and remove button clicked
    Then the reference is removed