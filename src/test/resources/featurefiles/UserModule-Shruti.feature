@userModuleShruti
  Feature: UserModule
  
  Background: 
  Given Admin sets authorization to bearer Token with token
  
 @usermodulePost
  Scenario: Check if admin is able to create a new Admin with valid endpoint and request body with mandatory fields-Post
    Given Admin creates POST request with all mandatory fields
    When Admin sends HTTPS Request with endpoint
    Then Admin receives 201 Created Status with response body.
 
@usermoduleGetAllUsers
  Scenario: Check if admin is able to retreive all the Users
    Given Admin creates GET Request
    When Admin sends HTTPS Request with GET All Users endpoint
    Then Admin receives 200 OK
  
  @usermoduleGetallRoles
  Scenario: Check if admin is able to retreive all the available roles-Get all roles
    Given Admin creates GET Request
    When Admin sends HTTPS Request with GET All Roles endpoint
    Then Admin receives 200 OK
 
  @usermoduleGetUserInfoByUserId
 Scenario: Check if admin able to retrieve User Information By User Id
   Given Admin creates GET Request
   When Admin sends HTTPS Request with valid endpoint
   Then Admin receives 200 OK Status with response body.
  
  @usermoduleGetAllUsersWIthRole
  Scenario: Check if admin able to retrieve all Admins with roles
    Given Admin creates GET Request 
    When  Admin sends HTTPS Request with roles endpoint 
    Then  Admin receives 200 OK Status with response body.                                                                 
  
  @usermoduleGetcountActiveInactiveUsers
  Scenario: Check if admin is able to get count of active and inactive Admins - Get Count of all active and inactive admins
    Given Admin creates GET Request
    When  Admin sends HTTPS Request with count of active and inactive user endpoint
    Then  Admin receives 200 OK
    
  # @usermoduleGetcountActiveInactiveUsersByRoleid
 # Scenario: Check if admin is able to get count of active and inactive Admins by role id
  #  Given Admin creates GET Request with role id
   #When  Admin sends HTTPS Request with "roles" endpoint
    #Then  Admin receives 200 OK
  
  @usermoduleGetAllActiveUsers
  Scenario: Check if admin is able to get Get All Active Users
    Given Admin creates GET Request 
   When  Admin sends HTTPS Request with activeUsers endpoint
   Then  Admin receives 200 OK
  
   @userModuleGetuserByPgmBatches
  Scenario: Check if admin is able to get the Admins by program batches for valid batch ID - Get Admins by Program batches
    Given Admin creates GET Request 
    When  Admin sends HTTPS Request with Batch endpoint along with ValidBatchId
    Then Admin receives 200 OK
    
   @userModuleGetAdminValidPgmId
  Scenario: Check if admin is able to get the Admins for valid program Id - Get Admin for program
    Given Admin creates GET Request 
    When  Admin sends HTTPS Request with Program endpoint alond with ProgramID
    Then  Admin receives 200 OK
 
   @userModuleGetUserByRoleID
   Scenario: Check if admin is able to retreive Admins by valid role ID -Get Admin by role ID
     Given Admin creates GET Request 
     When  Admin sends HTTPS Request with RoleID endpoint
     Then  Admin receives 200 OK
    
    @userModuleGetUserByRoleIdV2
   Scenario: Check if admin is able to retrieve all Admins with filters - Get Admin with filters
     Given Admin creates GET Request
     When  Admin sends HTTPS Request with role ID V2
     Then  Admin receives 200 OK
    
    @updateAdminInfo
  Scenario: Check if admin is able to update Admin details with Admin id and mandatory fields- Update Admin info with adminId
    Given Admin creates PUT Request with valid data in request body to update user  
    When  Admin sends HTTPS Request with admininfo endpoint
    Then  Admin receives 200 Ok status with message  
 
  @updateAdminrolestatus
    Scenario: Check if admin is able to update role status of a Admin with valid Admin id - update Admin role status by admin Id
      Given Admin creates PUT Request with valid data for role status in request body 
      When  Admin sends HTTPS Request with adminrole status endpoint
      Then  Admin receives 200 Ok Status with response message  
     
      @UpdateAdminRolePrgmBtachStatus
  Scenario: Check if admin is able to assign Admin to with program/batch by Admin Id - update admin role program batch status
    Given Admin creates PUT Request with valid data in request body to update user role pgm batch status
    When  Admin sends HTTPS Request with Prgmbatchstatus endpoint
    Then  Admin receives 200 Ok Status with response message after update 

@UpdateAdminRoleIdByAdminId
  Scenario: Check if admin is able to update role id of a Admin by valid Admin id -Update Admin roleID by admin id
    Given  The Admin creates PUT Request with valid request body
    When  Admin sends HTTPS Request with AdminID endpoint
    Then  Admin receives 200 OK success message with response body 
    
  @usermoduleUpdateLoginStatus
  Scenario: Check if admin is able to update the Admin login status by Admin ID
  Given Admin creates PUT Request with valid data in request body 
  When Admin sends PUT Request with endpoint
  Then Admin receives 200 OK with updated user response body