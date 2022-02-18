@Challenge
Feature: Registration

  #ESte test no puede ser completado porque no es posible
  #automatizar captchas. Ingresa toda la informacion
  # solicitada excepto el captcha.

  Scenario: Complete registration workflow
    Given Restart driver "YES"
    When User clicks on "REGISTER" button
    And Set email "RANDOM"
    And Set password "Test-1111"
    And Confirm password "Test-1111"
    And Clicks to accept terms & conditions
    And Submit the user info at page "REGISTER"