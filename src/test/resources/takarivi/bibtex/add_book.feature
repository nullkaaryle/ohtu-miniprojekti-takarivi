Feature: As a user I want to add a book

  Scenario: user can add a book with correct required fields
    Given add book is selected
    When valid data is given
      | Fields    | Values                   |
      | author    | O'Brian Patrick          |
      | title     | The Commodore            |
      | year      | 2012                     |
      | publisher | HarperCollins Publishers |
      | address   |                          |
      | edition   |                          |
      | key       |                          |
      | month     |                          |
      | note      |                          |
      | series    |                          |
      | volume    |                          |
    Then a list of references is showed