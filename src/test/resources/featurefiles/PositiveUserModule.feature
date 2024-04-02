@PositiveUserMOduleScenarios
 Feature: UserModule

    #@GetPrgm
  #Scenario: Check if admin is able to get the Admins for valid program Id - Get Program for program
   # Given Admin creates GET Request with valid program Id
    #When  Admin sends HTTPS Request with programId endpoint
    #Then  Admin receives 200 OK
    @GetAllActiveAdmins
    Scenario: Check if admin able to retrieve all active Admins
    Given Admin creates GET Request for retriving all active admin
    When  Admin sends HTTPS Request with all active admin endpoint
    Then  Admin receives 200 OK
    
    @GetAdminByRoleID
  Scenario: Check if admin is able to retreive Admins by valid role ID -Get Admin by role ID
    Given Admin creates GET Request with valid role ID
    When  Admin sends HTTPS Request with RoleID endpoint
    Then  Admin receives 200 OK
    
    @GetUserByRoleIdV2
  Scenario: Check if admin is able to retrieve all Admins with filters - Get Admin with filters
    Given Admin creates GET Request
    When  Admin sends HTTPS Request with endpoint
    Then  Admin receives 200 OK
    
  @UpdateAdminRoleIdByAdminId
  Scenario: Check if admin is able to update role id of a Admin by valid Admin id -Update Admin roleID by admin id
    Given  The Admin creates PUT Request with valid request body
    When  Admin sends HTTPS Request with AdminID endpoint
    Then  Admin receives 200 OK  Status with response body.  
    
   @UpdateAdminRolePrgmBtachStatus
  Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id - update admin role program batch status
    Given Admin creates PUT Request with valid data in request body
    When  Admin sends HTTPS Request with Prgmbatchstatus endpoint
    Then  Admin receives 200 Ok Status with response message