
@tag
Feature: UserRoleProgramBatchMapController
  

  @getAllAdminWithPgmBatch
  Scenario: Check if admin is able to retreive all Admins with assigned program batches
    Given Admin creates GET Request 
    When Admin sends HTTPS Request to retrieve all Admins assigned to programs/batches
    Then Admin receives 200 OK
    

 @getPgmBatchDetails
  Scenario: Check if admin is able to retreive assigned program batches for valid AdminId
    Given Admin creates GET Request 
    When Admin sends HTTPS Request to retrieve Admin assigned to Program/Batch by AdminId
    Then Admin receives 200 OK
    
    
    @deletePgmorBatch
  Scenario: Check if admin is able to delete the program batch for a Admin
    Given Admin creates DELETE Request to delete Admin assigned to program/batch by AdminId 
    When Admin sends DELETE HTTPS Request 
    Then Admin receives 200 OK
    