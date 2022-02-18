@Challenge
Feature: Sign

  Login workflow -negative scenarios


  Scenario Outline: Login, negative scenarios - <DESCRIPTION>
    Given Restart driver "<RESTART>"
    And User clicks on "<BUTTON>" button
    When User set username "<USERNAME>"
    And User set password "<PASSWORD>"
    And Submit the user info at page "<PAGE>"
    Then Validate result "<RESULT>"
    Examples:
      | DESCRIPTION                  | RESTART | BUTTON | USERNAME | PASSWORD  | PAGE   | RESULT            |
      | Login without email          | YES     | SIGNIN |          | Test-1111 | SIGNIN | BLANK_USERNAME    |
      | Login without password       | NO      |        | UserTest |           | SIGNIN | BLANK_PASSWORD    |
      | Login with blank credentials | NO      |        |          |           | SIGNIN | BLANK_CREDENTIALS |