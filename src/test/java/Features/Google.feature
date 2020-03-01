@GoogleFeature
Feature: Google Test Scenarios
  Scenario Outline: TC1 get google search result number
    Given I navigate to Google home
    When I verify the expected the title as Google
    When I type Cars <cars> in google search field
    And I submit or click on google search
    Then I capture and extract the search number
    Examples:
      | cars|
      | BMW|
      | Lexus|
      | Mercedes|

#    Scenario: TC2 login with invalid credentials
#    Given Navigated to google home page
#    When Click on ‘login’ link
#    Then Enter empty/blank email
#    And Click on ‘next’ button  THEN should receive an error message to prevent me from logging in with invalid credentials
