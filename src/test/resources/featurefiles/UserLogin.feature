@tag
Feature: User Login Post Request
 @tag1
 Scenario: Check if Admin able to generate token with valid credential
    Given Admin creates request with valid credentials
    When Admin calls Post Https method  with valid endpoint
    Then Admin receives 201 created with auto generated token