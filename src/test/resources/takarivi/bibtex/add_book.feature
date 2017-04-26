Feature: As a user I want to add a book

  Scenario: user can add a book with correct required fields
    Given add book is selected
    When valid data is given
    Then a list of references is showed
