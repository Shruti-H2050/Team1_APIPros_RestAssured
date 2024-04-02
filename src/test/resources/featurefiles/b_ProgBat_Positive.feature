@pgm
Feature: Programbatch_Postive

  @batch1
  Scenario: Check if Batch Admin able to create a program with valid endpoint and request body with Authorization
    Given Batch Admin creates Batch POST Request for the LMS with request body
    When Batch Admin sends Batch POST HTTPS Request and  request Body with endpoint
    Then Batch Admin receives 201 Batch Created Status with response body.

  @batch2
  Scenario: Check if Batch Admin able to create a program with missing values in the request body
    Given Batch Admin creates Batch POST Request for the LMS with request body
    When Batch Admin sends Batch POST HTTPS Request and request Body with endpoint with missing field
    Then Batch Admin receives 500 ok for Batch values in req body

  @Getbatchid
  Scenario: Check if Batch Admin able to retrieve a batches with valid batch ID
    Given Batch Admin creates Batch GET Request for the LMS API
    When Batch Admin sends Batch GET HTTPS Request with endpoint batchId
    Then Batch Admin receives 200 OK Status to reterive Batches with id with response body

  @Getbatchname
  Scenario: Check if Batch Admin able to retrieve all batches with valid batchname
    Given Batch Admin creates Batch GET Request for the LMS API
    When Batch Admin sends Batch GET HTTPS Request with endpoint batchName
    Then Batch Admin receives 200 OK Status with response body.

  @Getprogramid
  Scenario: Check if Batch Admin able to retrieve all batches with valid programid
    Given Batch Admin creates Batch GET Request for the LMS API
    When Batch Admin sends Batch GET HTTPS Request with endpoint programId
    Then Batch Admin receives 200 OK Status with response body.

  @updatebatchid
  Scenario: Check if Batch Admin able to update  batches with valid batchid
    Given Batch Admin creates Batch PUT Request for the LMS API
    When Batch Admin sends Batch PUT HTTPS Request with endpoint batchId and request
    Then Batch Admin receives 200 OK Status for updated Batches with response body.

  @deletebatchid
  Scenario: Check if Batch Admin able to delete batches with valid batchid
    Given Batch Admin creates Batch DELETE Request for the LMS API
    When Batch Admin sends Batch DELETE HTTPS Request with endpoint id
    Then Batch Admin receives 200 OK Status with response body.

  #@Getbatchname
  #Scenario: Check if Batch Admin able to retrieve all batches with valid batchname
   #Given Batch Admin creates GET Request for the LMS API
   #When Batch Admin sends HTTPS Request with endpoint batchName
   #Then Batch Admin receives 200 OK Status with response body.
