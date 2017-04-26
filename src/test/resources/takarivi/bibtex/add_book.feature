Feature: As a user I want to add a book

  Scenario: user can add a book with correct required fields
    Given add book is selected
    When valid book data is given
    Then a list of references is showed

Scenario: user can not add a book with incorrect required fields
    Given add book is selected
    When invalid book data is given
    Then a prompt is showed