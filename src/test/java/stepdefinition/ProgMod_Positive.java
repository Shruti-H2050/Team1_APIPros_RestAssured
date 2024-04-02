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
import payload.SaveProgramPOJO;
import payload.UpdateProgramByIdPOJO;
import payload.UpdateProgramByNamePOJO;
import utilities.BearerToken;

public class ProgMod_Positive {
	static RequestSpecification request = RestAssured.given().urlEncodingEnabled(true).log().all();
	static Response response;
	static String programId;
	static String programName;
	
	@Given("Admin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() throws InvalidFormatException, IOException {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("Admin sends HTTPS Request and  request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() throws Exception {
		 response = request.body(SaveProgramPOJO.getJsonString()).post(URLs.saveProgram);
		  programId = response.body().jsonPath().getString("programId");
		  programName = response.body().jsonPath().getString("programName");
	   
	}

	@When("Admin sends HTTPS Request with endpoint allprograms")
	public void admin_sends_https_request_with_endpoint_allprograms() {
		response = request.get(URLs.allPrograms);
	}

	@When("Admin sends HTTPS Request with endpoint programid")
	public void admin_sends_https_request_with_endpoint_programid() {
		 response = request.get(URLs.progid+programId);
	}

	@When("Admin sends HTTPS Request with endpoint allusers")
	public void admin_sends_https_request_with_endpoint_allusers() {
		response = request.get(URLs.progwithusers);
	}

	@Given("Admin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields() throws InvalidFormatException, IOException {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("Admin sends HTTPS Request with valid endpoint \\/putprogram\\/\\{programId}")
	public void admin_sends_https_request_with_valid_endpoint_putprogram() throws Exception {
		response = request.body(UpdateProgramByIdPOJO.getJsonString()).put(URLs.putprogramid+programId);
	}

	@Then("Admin receives {int} OK Status with updated value in response body.")
	public void admin_receives_ok_status_with_updated_value_in_response_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),200);
		response.prettyPrint();
	}

	@When("Admin sends HTTPS Request with valid endpoint \\/program\\/programName")
	public void admin_sends_https_request_with_valid_endpoint_program_program_name() throws Exception {
		response = request.body(UpdateProgramByNamePOJO.getJsonString()).put(URLs.putprogramname+programName);
	}

	@Given("Admin creates PUT Request for the LMS API endpoint  and  Valid program Name and status")
	public void admin_creates_put_request_for_the_lms_api_endpoint_and_valid_program_name_and_status() throws InvalidFormatException, IOException {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_name() throws InvalidFormatException, IOException {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("Admin sends HTTPS Request with endpoint delprogname")
	public void admin_sends_https_request_with_endpoint_delprogname() {
		response = request.delete(URLs.delprogname);
	}

	@Given("Admin creates DELETE Request for the LMS API endpoint  and  valid program ID")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_id() throws InvalidFormatException, IOException {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("Admin sends HTTPS Request with endpoint delprogramid")
	public void admin_sends_https_request_with_endpoint_delprogramid() {
		response = request.delete(URLs.delprogid);
	}



}
