@Pgm
  Feature: ProgramModule_Postive
   @Post1
  Scenario: Check if UserAdmin able to create a program with valid endpoint and request body with Authorization
    Given UserAdmin creates POST Request for the LMS with request body
    When UserAdmin sends HTTPS Request and  request Body with endpoint
    Then UserAdmin receives 201 Created Status with response body.
    @Post2
  Scenario: Check if UserAdmin able to create a program with missing values in the request body
    Given UserAdmin creates POST Request for the LMS with request body
    When UserAdmin sends HTTPS Request and  request Body with endpoint with missing field
    Then UserAdmin receives 500 ok
    @GetAllPrograms
  Scenario: Check if UserAdmin able to retrieve all programs with valid Endpoint
    Given UserAdmin creates GET Request for the LMS API
    When UserAdmin sends HTTPS Request with endpoint allprograms
    Then UserAdmin receives 200 OK Status with response body.
		@GetProgramid
  Scenario: Check if UserAdmin able to retrieve a program with valid program ID
    Given UserAdmin creates GET Request for the LMS API
    When UserAdmin sends HTTPS Request with endpoint programid
    Then UserAdmin receives 200 OK Status with response body.
    @GetAllWithUserAdmins
  Scenario: Check if UserAdmin able to retrieve all programs with valid Endpoint
    Given UserAdmin creates GET Request for the LMS API
    When  UserAdmin sends HTTPS Request with endpoint allusers
    Then UserAdmin receives 200 OK Status with response body.
     @PutProgramid
  Scenario: Check if UserAdmin able to update a program with valid programID endpoint  and valid request body
    Given UserAdmin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.
    When UserAdmin sends HTTPS Request with valid endpoint /putprogram/{programId}
    Then UserAdmin receives 200 OK Status with updated value in response body.
  @PutProgramName1
  Scenario: Check if UserAdmin able to update a program with  Valid program Name and request body
    Given UserAdmin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.
   	When UserAdmin sends HTTPS Request with valid endpoint /program/programName
    Then UserAdmin receives 200 OK Status with updated value in response body.
 @PutProgramName2
  Scenario: Check if UserAdmin able to update a program status
    Given UserAdmin creates PUT Request for the LMS API endpoint  and  Valid program Name and status
   	When UserAdmin sends HTTPS Request with valid endpoint /program/programName
    Then UserAdmin receives 200 OK Status with updated value in response body.
    @DelProgramName
  Scenario: Check if UserAdmin able to delete a program with valid programName
    Given UserAdmin creates DELETE Request for the LMS API endpoint  and  valid programName
    When  UserAdmin sends HTTPS Request with endpoint delprogname
    Then  UserAdmin receives 200 Ok status with message
    @DelProgramid
  Scenario: Check if UserAdmin able to delete a program with valid program ID
    Given UserAdmin creates DELETE Request for the LMS API endpoint  and  valid program ID
    When  UserAdmin sends HTTPS Request with endpoint delprogramid
    Then  UserAdmin receives 200 Ok status with message


























