package stepdefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserLogin {

	private String BaseURL;
	private String loginEndpoint;
	private String requestBody;
	RequestSpecification request = RestAssured.given();
	
	List<String> allResponses = new ArrayList<String>();	
	
	@Given("User is provided with Base URL and Request body from the {string}")
	public void user_is_provided_with_base_url_and_request_body_from_the(String string) throws InvalidFormatException, IOException {
		
		List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.Excelpath, "Sheet 1");
		for (Map<String, String> row : map) {
			String password = row.get("password");
			String loginEmailid = row.get("userLoginEmailId");
			String payload = "{\n"
					+ "  \"password\": \"string\",\n"
					+ "  \"userLoginEmailId\": \"string\"\n"
					+ "}\n"
					+ "";
			request.header("Content-Type","application/json");
			Response responseGetGeneratedToken = request.baseUri(URLs.BaseURL).basePath(URLs.loginEndpoint).contentType(ContentType.JSON).body(payload).post();
			responseGetGeneratedToken.prettyPrint();
			
			//*****Must add JSON-PATH dependency in pom******
			String jsonString = responseGetGeneratedToken.getBody().asString();
			String tokenGenerated = JsonPath.from(jsonString).get("token");
			request.header("Authorization","Bearer "+tokenGenerated).header("Content-Type","application/json");
			
			
			//allResponses.add(responseBody);
			//System.out.println("Response " + row + ":");
			//System.out.println(responseBody);
		
	}
	}

	@When("user send the Post request")
	public void user_send_the_post_request() {
	   
	}

	@Then("user validate the response")
	public void user_validate_the_response() {
	   
	}
}
