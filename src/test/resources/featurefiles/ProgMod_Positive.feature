@Pgm
  Feature: ProgramModule_Postive
   @Post1
  Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
    Given Admin creates POST Request for the LMS with request body
    When Admin sends HTTPS Request and  request Body with endpoint
    Then Admin receives 201 Created Status with response body.
    @Post2
  Scenario: Check if Admin able to create a program with missing values in the request body
    Given Admin creates POST Request for the LMS with request body
    When Admin sends HTTPS Request and  request Body with endpoint with missing field
    Then Admin receives 500 ok
    @GetAllPrograms
  Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    Given Admin creates GET Request for the LMS API
    When Admin sends HTTPS Request with endpoint allprograms
    Then Admin receives 200 OK Status with response body.
		@GetProgramid
  Scenario: Check if Admin able to retrieve a program with valid program ID
    Given Admin creates GET Request for the LMS API
    When Admin sends HTTPS Request with endpoint programid
    Then Admin receives 200 OK Status with response body.
    @GetAllWithAdmins
  Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    Given Admin creates GET Request for the LMS API
    When  Admin sends HTTPS Request with endpoint allusers
    Then Admin receives 200 OK Status with response body.
     @PutProgramid
  Scenario: Check if Admin able to update a program with valid programID endpoint  and valid request body
    Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.
    When Admin sends HTTPS Request with valid endpoint /putprogram/{programId}
    Then Admin receives 200 OK Status with updated value in response body.
  @PutProgramName1
  Scenario: Check if Admin able to update a program with  Valid program Name and request body
    Given Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.
   	When Admin sends HTTPS Request with valid endpoint /program/programName
    Then Admin receives 200 OK Status with updated value in response body.
 @PutProgramName2
  Scenario: Check if Admin able to update a program status
    Given Admin creates PUT Request for the LMS API endpoint  and  Valid program Name and status
   	When Admin sends HTTPS Request with valid endpoint /program/programName
    Then Admin receives 200 OK Status with updated value in response body.
    @DelProgramName
  Scenario: Check if Admin able to delete a program with valid programName
    Given Admin creates DELETE Request for the LMS API endpoint  and  valid programName
    When  Admin sends HTTPS Request with endpoint delprogname
    Then  Admin receives 200 Ok status with message
    @DelProgramid
  Scenario: Check if Admin able to delete a program with valid program ID
    Given Admin creates DELETE Request for the LMS API endpoint  and  valid program ID
    When  Admin sends HTTPS Request with endpoint delprogramid
    Then  Admin receives 200 Ok status with message


























