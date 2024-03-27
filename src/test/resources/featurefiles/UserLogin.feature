@tag
Feature: User Login Post Request
  @tag1
  Scenario: Check User is able to login with valid credintials,valid URL and valid endpoint
    Given User is provided with Base URL and Request body from the "<sheetName>"
    When user send the Post request
    Then user validate the response
    
    Examples:
    |  sheetName  |
    |  REST       |