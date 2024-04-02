package stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.BatchPutPayload;
import payload.batchesmissingpayload;
import payload.batchespojo;
import utilities.BearerToken;

public class ProgBat_PositiveStepDef {
	static RequestSpecification request = RestAssured.given().urlEncodingEnabled(true).log().all();
	static Response response;
	static String batchId;
	static String batchName;
	
	@Given("Batch Admin creates Batch POST Request for the LMS with request body")
	public void batch_admin_creates_batch_post_request_for_the_lms_with_request_body() throws InvalidFormatException, IOException {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("Batch Admin sends Batch POST HTTPS Request and  request Body with endpoint")
	public void batch_admin_sends_batch_post_https_request_and_request_body_with_endpoint() throws Exception {
		 response = request.body(batchespojo.getJsonString()).post(URLs.postcreateendpoint);
		  batchId= response.body().jsonPath().getString("batchId");
		  batchName= response.body().jsonPath().getString("batchName");
	}

	@Then("Batch Admin receives {int} Batch Created Status with response body.")
	public void batch_admin_receives_batch_created_status_with_response_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),201);
		response.prettyPrint();
	}

	@When("Batch Admin sends Batch POST HTTPS Request and request Body with endpoint with missing field")
	public void batch_admin_sends_batch_post_https_request_and_request_body_with_endpoint_with_missing_field() throws Exception {
		response = request.body(batchesmissingpayload.getJsonString()).post(URLs.postcreateendpoint);
	}

	@Then("Batch Admin receives {int} ok for Batch values in req body")
	public void batch_admin_receives_ok_for_batch_values_in_req_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),500);
		response.prettyPrint();
	}

	@Given("Batch Admin creates Batch GET Request for the LMS API")
	public void batch_admin_creates_batch_get_request_for_the_lms_api() throws InvalidFormatException, IOException {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("Batch Admin sends Batch GET HTTPS Request with endpoint batchId")
	public void batch_admin_sends_batch_get_https_request_with_endpoint_batch_id() {
		System.out.println(batchId);
		response=request.get(URLs.getbatchidendpoint + batchId);
		
	}

	@Then("Batch Admin receives {int} OK Status to reterive Batches with id with response body")
	public void batch_admin_receives_ok_status_to_reterive_batches_with_id_with_response_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),200);
		response.prettyPrint();
	}

	@When("Batch Admin sends Batch GET HTTPS Request with endpoint batchName")
	public void batch_admin_sends_batch_get_https_request_with_endpoint_batch_name() {
		response=request.get(URLs.getbatchnameendpoint + batchName);
	}

	@When("Batch Admin sends Batch GET HTTPS Request with endpoint programId")
	public void batch_admin_sends_batch_get_https_request_with_endpoint_program_id() {
		response=request.get(URLs.getbatchprogramidendpoint);
	}

	@Given("Batch Admin creates Batch PUT Request for the LMS API")
	public void batch_admin_creates_batch_put_request_for_the_lms_api() throws InvalidFormatException, IOException {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("Batch Admin sends Batch PUT HTTPS Request with endpoint batchId and request")
	public void batch_admin_sends_batch_put_https_request_with_endpoint_batch_id_and_request() throws Exception {
		response=request.body(BatchPutPayload.getJsonString()).put(URLs.updatebatchidendpoint + batchId); 
		System.out.println("This is batch Id" + batchId);
	}

	@Then("Batch Admin receives {int} OK Status for updated Batches with response body.")
	public void batch_admin_receives_ok_status_for_updated_batches_with_response_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),200);
		response.prettyPrint();
	}

	@Given("Batch Admin creates Batch DELETE Request for the LMS API")
	public void batch_admin_creates_batch_delete_request_for_the_lms_api() throws InvalidFormatException, IOException {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("Batch Admin sends Batch DELETE HTTPS Request with endpoint id")
	public void batch_admin_sends_batch_delete_https_request_with_endpoint_id() {
		response=request.delete(URLs.deletebatchidendpoint + batchId);
	}

	@Then("Batch Admin receives {int} OK Status with response body.")
	public void batch_admin_receives_ok_status_with_response_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),200);
		response.prettyPrint();
	    
	}


}
