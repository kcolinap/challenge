@Challenge
Feature: Sign

  Add all scenarios to test registration functionality

  #ESte test no puede ser completado porque no es posible
  #automatizar captchas. Ingresa toda la informacion
  # solicitada excepto el captcha.

  Scenario Outline: Login, negative scenarios - <DESCRIPTION>
    Given Restart driver "YES"
    When User clicks on "SIGNIN" button
    And Set email "RANDOM"
    And Set password "Test-1111"
    And Confirm password "Test-1111"
    And Clicks to accept terms & conditions
    And Submit the user info