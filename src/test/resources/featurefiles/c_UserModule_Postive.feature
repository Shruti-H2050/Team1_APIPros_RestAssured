@userModule
  Feature: UserModule
  
 # Background: 
 # Given administrator sets authorization to bearer Token with token
  
 @usermodulePost
  Scenario: Check if administrator is able to create a new administrator with valid endpoint and request body with mandatory fields-Post
    Given administrator creates POST request with all mandatory fields
    When administrator sends HTTPS Request with endpoint
    Then administrator receives 201 Created Status with response body.
 
@usermoduleGetAllUsers
  Scenario: Check if admin is able to retreive all the Users
    Given administrator creates GET Request
    When administrator sends HTTPS Request with GET All Users endpoint
    Then administrator receives 200 OK
  
  @usermoduleGetallRoles
  Scenario: Check if admin is able to retreive all the available roles-Get all roles
    Given administrator creates GET Request
    When administrator sends HTTPS Request with GET All Roles endpoint
    Then administrator receives 200 OK
 
  @usermoduleGetUserInfoByUserId
 Scenario: Check if admin able to retrieve User Information By User Id
   Given administrator creates GET Request
   When administrator sends HTTPS Request with valid endpoint
   Then administrator receives 200 OK Status with response body.
  
  @usermoduleGetAllUsersWIthRole
  Scenario: Check if admin able to retrieve all administrators with roles
    Given administrator creates GET Request 
    When  administrator sends HTTPS Request with roles endpoint 
    Then  administrator receives 200 OK Status with response body.                                                                 
  
  @usermoduleGetcountActiveInactiveUsers
  Scenario: Check if admin is able to get count of active and inactive administrators - Get Count of all active and inactive admins
    Given administrator creates GET Request
    When  administrator sends HTTPS Request with count of active and inactive user endpoint
    Then  administrator receives 200 OK
    
  # @usermoduleGetcountActiveInactiveUsersByRoleid
 # Scenario: Check if admin is able to get count of active and inactive administrators by role id
  #  Given administrator creates GET Request with role id
   #When  administrator sends HTTPS Request with "roles" endpoint
    #Then  administrator receives 200 OK
  
  @usermoduleGetAllActiveUsers
  Scenario: Check if admin is able to get Get All Active Users
    Given administrator creates GET Request 
   When  administrator sends HTTPS Request with activeUsers endpoint
   Then  administrator receives 200 OK
  
  # @userModuleGetuserByPgmBatches
# Scenario: Check if user is able to get the administrators by program batches for valid batch ID - Get administrators by Program batches
#   Given user creates GET Request 
#   When user sends HTTPS Request with Batch endpoint along with ValidBatchId
#   Then user receives 200 OK
  
# @userModuleGetadministratorValidPgmId
# Scenario: Check if user is able to get the administrators for valid program Id - Get administrator for program
#   Given user creates GET Request 
#   When user sends HTTPS Request with Program endpoint along with ProgramID
#   Then user receives 200 OK
 
   @userModuleGetUserByRoleID
   Scenario: Check if admin is able to retreive administrators by valid role ID -Get administrator by role ID
     Given administrator creates GET Request 
     When  administrator sends HTTPS Request with RoleID endpoint
     Then  administrator receives 200 OK
    
    @userModuleGetUserByRoleIdV2
   Scenario: Check if admin is able to retrieve all administrators with filters - Get administrator with filters
     Given administrator creates GET Request
     When  administrator sends HTTPS Request with role ID V2
     Then  administrator receives 200 OK
    
  # @updateadministratorInfo
# Scenario: Check if admin is able to update administrator details with administrator id and mandatory fields- Update administrator info with adminId
#   Given administrator creates PUT Request with valid data in request body to update user  
#   When  administrator sends HTTPS Request with admininfo endpoint
#   Then  administrator receives 200 Ok status with message   
 
 # @updateadministratorrolestatus
# Scenario: Check if admin is able to update role status of a administrator with valid administrator id - update administrator role status by admin Id
# This scenario checks whether the admin can update the role status of another admin using a valid admin ID.
# Given administrator creates PUT Request with valid data for role status in request body 
# When  administrator sends HTTPS Request with adminrole status endpoint
# Then  administrator receives 200 Ok Status with response message  

# @UpdateadministratorRolePrgmBtachStatus
# Scenario: Check if admin is able to assign administrator to with program/batch by administrator Id - update admin role program batch status
# This scenario verifies if the admin can assign a program/batch to another admin using their admin ID.
# Given administrator creates PUT Request with valid data in request body to update user role pgm batch status
# When  administrator sends HTTPS Request with Prgmbatchstatus endpoint
# Then  administrator receives 200 Ok Status with response message after update 

# @UpdateadministratorRoleIdByadministratorId
# Scenario: Check if admin is able to update role id of a administrator by valid administrator id -Update administrator roleID by admin id
# This scenario validates whether the admin can update the role ID of another admin using a valid admin ID.
# Given  The administrator creates PUT Request with valid request body
# When  administrator sends HTTPS Request with administratorID endpoint
# Then  administrator receives 200 OK success message with response body 
    
 # @usermoduleUpdateLoginStatus
  #Scenario: Check if admin is able to update the administrator login status by administrator ID
#  Given administrator creates PUT Request with valid data in request body 
  #When administrator sends PUT Request with endpoint
  #Then administrator receives 200 OK with updated user response body