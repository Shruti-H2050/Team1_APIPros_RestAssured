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
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import payload.UpdateUserPayload;
import payload.UpdateUserRoleIdPayload;
import payload.UpdateUserRoleStatusPayload;
import payload.UserModulePayload;
import payload.UserModuleUpdateUserLoginStatusPayload;
import utilities.AuthToken;
import utilities.BearerToken;

public class UserModuleShruti {
	
	static  String bearertoken;
	String baseUrl = URLs.BaseURL;
	String getAllUsersURL = URLs.getAllUsers;
	String getAllRolesURL = URLs.getAllRoles;
	String getUserInfoByIdURL = URLs.getUserInfoById;
	String createNewUser = URLs.createUserwithRole;
	String updateLoginStatus = URLs.updateUserLoginStatus;
	String getUsersWithRole = URLs.getUsersWithRole;
	UserModulePayload userModulePayloadObj = new UserModulePayload();
	 
	RequestSpecification request = RestAssured.given().urlEncodingEnabled(true).log().all();
	Response response;
	static  RequestSpecification reqspecput;
	static  RequestSpecification reqspecuserrolestaus;
	static RequestSpecification putreqspec;
	static Response putResponse;
	static  Response responseput;
	static  Response responseuserrolestatus;
	

	@Given("Admin sets authorization to bearer Token with token")
	public void admin_sets_authorization_to_bearer_token_with_token() throws InvalidFormatException, IOException {
		bearertoken = BearerToken.bearertoken();
	}

	@Given("Admin creates POST request with all mandatory fields")
	public void admin_creates_post_request_with_all_mandatory_fields() throws InvalidFormatException, IOException {
	   request.baseUri(baseUrl);
	   request.header("Content-Type","application/json");
	   request.header("Authorization", "Bearer " + bearertoken);
	   
	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() throws IOException {
	   response = request.body(UserModulePayload.UserModulePostRequestBody()).post(createNewUser);
	}

	@Then("Admin receives {int} Created Status with response body.")
	public void admin_receives_created_status_with_response_body(Integer int1) {
		response.getBody().prettyPrint();
		System.out.println(response.getStatusCode());
	    System.out.println(response.getStatusLine());
		Assert.assertEquals(response.statusCode(),201);
	}

	@Given("Admin creates GET Request")
	public void admin_creates_get_request() throws InvalidFormatException, IOException {
		request.baseUri(baseUrl);
		request.header("Authorization", "Bearer " + AuthToken.getBearerToken());
		request.header("Content-Type","application/json");
	}

	@When("Admin sends HTTPS Request with GET All Users endpoint")
	public void admin_sends_https_request_with_get_all_users_endpoint() {
		response=request.get(getAllUsersURL);
	}


	@When("Admin sends HTTPS Request with GET All Roles endpoint")
	public void admin_sends_https_request_with_get_all_roles_endpoint() {
		response=request.get(getAllRolesURL);
	}


	@Then("Admin receives {int} OK")
	public void admin_receives_ok(Integer int1) {
		Assert.assertEquals(response.statusCode(),200);
		response.prettyPrint();
	}

	@When("Admin sends HTTPS Request with valid endpoint")
	public void admin_sends_https_request_with_valid_endpoint() {
		response=request.get(getUserInfoByIdURL);
	}

	@Then("Admin receives {int} OK Status with response body.")
	public void admin_receives_ok_status_with_response_body(Integer int1) {
		Assert.assertEquals(response.statusCode(),200);
		System.out.println(response.getStatusLine());
		response.prettyPrint();
	}

	@When("Admin sends HTTPS Request with roles endpoint")
	public void admin_sends_https_request_with_roles_endpoint() {
		response=request.get(getUsersWithRole);
		response.prettyPrint();
	}
	@When("Admin sends HTTPS Request with count of active and inactive user endpoint")
	public void admin_sends_https_request_with_count_of_active_and_inactive_user_endpoint() {
		response=request.get(URLs.countActiveInactiveUsers);
	}
	
	@When("Admin sends HTTPS Request with activeUsers endpoint")
	public void admin_sends_https_request_with_active_users_endpoint() {
	    response=request.get(URLs.getAllActiveUsers);
	}

	@When("Admin sends HTTPS Request with Batch endpoint along with ValidBatchId")
	public void admin_sends_https_request_with_batch_endpoint_along_with_valid_batch_id() {
		response=request.get(URLs.getUserswithBatchId);
	}

	@When("Admin sends HTTPS Request with Program endpoint alond with ProgramID")
	public void admin_sends_https_request_with_program_endpoint_alond_with_program_id() {
		response=request.get(URLs.getUserswithPgmId);
	}
	@When("Admin sends HTTPS Request with RoleID endpoint")
	public void admin_sends_https_request_with_role_id_endpoint() {
		response=request.get(URLs.getUserByRoleId);
	}

	@When("Admin sends HTTPS Request with role ID V2")
	public void admin_sends_https_request_with_role_id_v2() {
		response=request.get(URLs.getUserByRoleIdV2);
	}
	//12-UpdateUser
	@Given("Admin creates PUT Request with valid data in request body to update user")
	public void admin_creates_put_request_with_valid_data_in_request_body_to_update_user() throws InvalidFormatException, IOException {
		reqspecput=RestAssured.given().baseUri(URLs.BaseURL).header("Content-Type","application/json")
                .header("Authorization", "Bearer " + bearertoken)
                .body(UpdateUserPayload.admininfo());
	}
	@When("Admin sends HTTPS Request with admininfo endpoint")
	public void admin_sends_https_request_with_admininfo_endpoint() {
		responseput= reqspecput.when().put(URLs.updateUser);
	}

	@Then("Admin receives {int} Ok status with message")
	public void admin_receives_ok_status_with_message(Integer expcode) {
		responseput.getBody().prettyPrint();
		System.out.println(response.getStatusCode());
	    System.out.println(response.getStatusLine());
		expcode=response.getStatusCode();
	    Assert.assertEquals(200, expcode);
	}
	//13-Update User Role Status
	@Given("Admin creates PUT Request with valid data for role status in request body")
	public void admin_creates_put_request_with_valid_data_for_role_status_in_request_body() throws InvalidFormatException, IOException {
		 reqspecuserrolestaus=RestAssured.given().baseUri(URLs.BaseURL).header("Content-Type","application/json")
	                .header("Authorization", "Bearer " + bearertoken)
	                .body(UpdateUserRoleStatusPayload.userrolestatus());
	}

	@When("Admin sends HTTPS Request with adminrole status endpoint")
	public void admin_sends_https_request_with_adminrole_status_endpoint() {
		responseuserrolestatus =reqspecuserrolestaus.when().put(URLs.UpdateUserrolestus);
	}

	@Then("Admin receives {int} Ok Status with response message")
	public void admin_receives_ok_status_with_response_message(Integer expcode) {
		responseuserrolestatus.getBody().prettyPrint();
		//Assert.assertEquals(responseuserrolestatus.statusCode(),200);
		System.out.println(responseuserrolestatus.getStatusCode());
	    System.out.println(responseuserrolestatus.getStatusLine());
		expcode=responseuserrolestatus.getStatusCode();
	   Assert.assertEquals(200, expcode);
	}
	@Given("The Admin creates PUT Request with valid request body")
	public void the_admin_creates_put_request_with_valid_request_body() throws InvalidFormatException, IOException {
		putreqspec = RestAssured.given().baseUri(URLs.BaseURL).header("Content-Type","application/json")
                .header("Authorization", "Bearer " + bearertoken).body(UpdateUserRoleIdPayload.userroleID());
	}

	@When("Admin sends HTTPS Request with AdminID endpoint")
	public void admin_sends_https_request_with_admin_id_endpoint() {
	    
	}

	@Then("Admin receives {int} OK success message with response body")
	public void admin_receives_ok_success_message_with_response_body(Integer int1) {
		
	}
	@Given("Admin creates PUT Request with valid data in request body to update user role pgm batch status")
	public void admin_creates_put_request_with_valid_data_in_request_body_to_update_user_role_pgm_batch_status() {
		/*
		 * putreqspec = RestAssured.given().baseUri(URLs.BaseURL)
		 * .header("Authorization", "Bearer " + bearertoken)
		 * .header("Content-Type","application/json")
		 * .body(UpdateRolePgrmbatchStatus.userrolepgmbatchstatus());
		 */
	}

	@When("Admin sends HTTPS Request with Prgmbatchstatus endpoint")
	public void admin_sends_https_request_with_prgmbatchstatus_endpoint() {
		 putResponse = putreqspec.when().post(URLs.updateUserRolePrgmBatchStatu);
	}

	@Then("Admin receives {int} Ok Status with response message after update")
	public void admin_receives_ok_status_with_response_message_after_update(Integer expectedCode) {
		putResponse.getBody().prettyPrint();
		System.out.println(response.getStatusCode());
	    System.out.println(response.getStatusLine());
		expectedCode=response.getStatusCode();
	    Assert.assertEquals(200, expectedCode);
	}


	@Given("Admin creates PUT Request with valid data in request body")
	public void admin_creates_put_request_with_valid_data_in_request_body() {
		 request.baseUri(baseUrl);
		   request.header("Content-Type","application/json");
		   request.header("Authorization", "Bearer " + bearertoken);
	}

	@When("Admin sends PUT Request with endpoint")
	public void admin_sends_put_request_with_endpoint() throws IOException {
		 response = request.body(UserModuleUpdateUserLoginStatusPayload.UserModulePutRequestBody()).put(updateLoginStatus);
	}

	@Then("Admin receives {int} OK with updated user response body")
	public void admin_receives_ok_with_updated_user_response_body(Integer int1) {
	   
	}
	@Given("Admin creates GET Request with role id")
	public void admin_creates_get_request_with_role_id() {
	   
	}
	@When("Admin sends HTTPS Request with {string} endpoint")
	public void admin_sends_https_request_with_endpoint(String string) {
	   
	}
}
