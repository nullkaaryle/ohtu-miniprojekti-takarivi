Feature: As a user I want to add an article

    Scenario: user can add an article with correct required fields
        Given add article is selected
        When "author" is given
        And "journal" is given
        And "title" is given
        And "5" is given
        And "2012" is given
        And "" is given
        And "" is given
        And "" is given
        And "" is given
        And "" is given
        And "" is given
        Then article is added

#    Scenario: user cannot add an article with required fields missing
#        Given add article is selected
#        When "" is given
#        Then error message is shown and article is not added
#        
#    Scenario: user cannot add invalid values to required fields
#        Given add article is selected
#        When "aa11" is given
#        And "author" is given
#        And "title" is given
#        And "journal" is given
#        And "invalidvalue" is given
#        Then error message is shown and article is not added