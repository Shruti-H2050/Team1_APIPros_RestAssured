package stepdefinition;

import org.testng.Assert;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payload.MissingfieldsPOJO;
import payload.UpdateProgramByNamePOJO;
import payload.UpdateProgramByIdPOJO;
import payload.SaveProgramPOJO;
import utilities.AuthToken;
import utilities.BearerToken;

public class ProgMod_PostiveStepDef {
	
	static RequestSpecification request = RestAssured.given().urlEncodingEnabled(true).log().all();
	static Response response;
	static String programId;
	static String programName;
	
	//@Post1
	@Given("UserAdmin creates POST Request for the LMS with request body")
	public void admin_creates_post_request_for_the_lms_with_request_body() throws Exception {
	
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
			
	}

	@When("UserAdmin sends HTTPS Request and  request Body with endpoint")
	public void admin_sends_https_request_and_request_body_with_endpoint() throws Exception {
		
		
		
		/*Program p1 = new Program("SDET"+Common.getRandomInt(),"APIPros","Active");
		ObjectMapper objectMapper = new ObjectMapper();
		String reqBodyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(p1);
		System.out.println(reqBodyJson);*/
	  response = request.body(SaveProgramPOJO.getJsonString()).post(URLs.saveProgram);
	  programId = response.body().jsonPath().getString("programId");
	  programName = response.body().jsonPath().getString("programName");
	  
	}
		
	@Then("UserAdmin receives {int} Created Status with response body.")
	public void admin_receives_created_status_with_response_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),201);
		response.prettyPrint();
	}
	
	// @Post2
	@When("UserAdmin sends HTTPS Request and  request Body with endpoint with missing field")
	public void admin_sends_https_request_and_request_body_with_endpoint_with_missing_field() throws Exception {
		/*ProgramMissingField p2 = new ProgramMissingField("SDET"+Common.getRandomInt(),"Active");
		ObjectMapper objectMapper = new ObjectMapper();
		String reqBodyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(p2);
		System.out.println(reqBodyJson);*/
	  response = request.body(MissingfieldsPOJO.getJsonString()).post(URLs.saveProgram);
	}

	@Then("UserAdmin receives {int} ok")
	public void admin_receives_ok(Integer int1) {
	    
		Assert.assertEquals(response.statusCode(),500);
		response.prettyPrint();
	}
	 // @GetAllPrograms
	@Given("UserAdmin creates GET Request for the LMS API")
	public void admin_creates_get_request_for_the_lms_api() throws Exception, Exception {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("UserAdmin sends HTTPS Request with endpoint allprograms")
	public void admin_sends_https_request_with_endpoint_allprograms() {
		response = request.get(URLs.allPrograms);
	}

	
	//@GetProgramid
	@When("UserAdmin sends HTTPS Request with endpoint programid")
	public void admin_sends_https_request_with_endpoint_programid() {
	    response = request.get(URLs.progid+programId);
	}

	
	//@GetAllWithUserAdmins
	@When("UserAdmin sends HTTPS Request with endpoint allusers")
	public void admin_sends_https_request_with_endpoint_allusers() {
	    response = request.get(URLs.progwithusers);
	}
		

	@Then("UserAdmin receives {int} OK Status with response body.")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),200);
		response.prettyPrint();
	}

	// @PutProgramid
	@Given("UserAdmin creates PUT Request for the LMS API endpoint with request Body with mandatory , additional  fields.")
	public void admin_creates_put_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields() throws Exception, Exception {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}
	

	@When("UserAdmin sends HTTPS Request with valid endpoint \\/putprogram\\/\\{programId}")
	public void admin_sends_https_request_with_valid_endpoint_putprogram() throws Exception {
		/*Program p1 = new Program("SDET"+Common.getRandomInt(),"restassured","Active");
		ObjectMapper objectMapper = new ObjectMapper();
		String reqBodyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(p1);
		System.out.println(reqBodyJson);*/
		
	  response = request.body(UpdateProgramByIdPOJO.getJsonString()).put(URLs.putprogramid+programId); 
	}

	@Then("UserAdmin receives {int} OK Status with updated value in response body.")
	public void admin_receives_ok_status_with_updated_value_in_response_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),200);
		response.prettyPrint();
	}


	//@PutProgramName1
	@When("UserAdmin sends HTTPS Request with valid endpoint \\/program\\/programName")
	public void admin_sends_https_request_with_valid_endpoint_program_program_name() throws Exception {
		/*Program p1 = new Program("SDET"+Common.getRandomInt(),"testing program name changed","Inactive");
		ObjectMapper objectMapper = new ObjectMapper();
		String reqBodyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(p1);
		System.out.println(reqBodyJson);*/
		
	  response = request.body(UpdateProgramByNamePOJO.getJsonString()).put(URLs.putprogramname+programName);
	}
	
	// @PutProgramName2
	@Given("UserAdmin creates PUT Request for the LMS API endpoint  and  Valid program Name and status")
	public void admin_creates_put_request_for_the_lms_api_endpoint_and_valid_program_name_and_status() throws Exception, Exception {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	 //@DelProgramName
	@Given("UserAdmin creates DELETE Request for the LMS API endpoint  and  valid programName")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_name() throws Exception, Exception {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("UserAdmin sends HTTPS Request with endpoint delprogname")
	public void admin_sends_https_request_with_endpoint_delprogname() throws Exception {
			
	  response = request.delete(URLs.delprogname);
	}

	@Then("UserAdmin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer int1) {
		Assert.assertEquals(response.statusCode(),200);
		response.prettyPrint();
	}

	//@DelProgramid
	@Given("UserAdmin creates DELETE Request for the LMS API endpoint  and  valid program ID")
	public void admin_creates_delete_request_for_the_lms_api_endpoint_and_valid_program_id() throws Exception, Exception {
		request.baseUri(URLs.BaseURL);
		request.header("Authorization", "Bearer " + BearerToken.bearertoken());
		request.header("Content-Type","application/json");
	}

	@When("UserAdmin sends HTTPS Request with endpoint delprogramid")
	public void admin_sends_https_request_with_endpoint_delprogramid() {
		response = request.delete(URLs.delprogid); 
	}

}
