package stepdefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.Assert;


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
import io.restassured.specification.ResponseSpecification;
import payload.Pojo;

public class UserLogin {

	private String BaseURL;
	private String loginEndpoint;
	private String requestBody;
	Response response;
	//RequestSpecification request = RestAssured.given();
	
	List<String> allResponses = new ArrayList<String>();	
	
	@Given("Admin creates request with valid credentials")
	public void admin_creates_request_with_valid_credentials() throws IOException {
		
		
		//RequestSpecification request = RestAssured.given();
		
			
			List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.Excelpath, "Sheet 4 - Table 1-1");
			for (Map<String, String> row : map) {
				String mypwd = row.get("password");
				String userLoginEmailId = row.get("userLoginEmailId");
				RestAssured.baseURI = URLs.BaseURL;
				RequestSpecification request = RestAssured.given();
					String userInfoJson = "{" +
							"\"password\": \"" + mypwd + "\"," +
							"\"userLoginEmailId\": \"" + userLoginEmailId + "\"}" ;
							//"}";
					System.out.println(userInfoJson);
				
				
				request.header("Content-Type","application/json");
				Response responseFromGenerateToken = request.body(userInfoJson).post(URLs.loginEndpoint);
				responseFromGenerateToken.prettyPrint();
				
				//Extracting token from response
				String jsonString = responseFromGenerateToken.getBody().asString();
				String tokenGenerated = JsonPath.from(jsonString).get("token");
				request.header("Authorization","Bearer "+tokenGenerated).header("Content-Type","application/json");
			}		
		
		/*
		 * response= RestAssured.given().baseUri(URLs.BaseURL)
		 * .header("Content-Type","application/json") .body(Pojo.logincred()) .when()
		 * .post(URLs.loginEndpoint); String jsonString = response.getBody().asString();
		 * static String tokenGenerated = JsonPath.from(jsonString).get("token");
		 */
		
		//String responseinStringform=response.asString();
		
		//	System.out.println(response.asString());

			//JsonPath jsonpath = new JsonPath(responseinStringform, null);
			//String responsestatus = jsonpath.get("status");
		//	System.out.println(jsonpath.get("token").toString());






		
		
			/*
			 * RestAssured.baseURI = URLs.BaseURL; RequestSpecification request =
			 * RestAssured.given(); request.header("Content-Type","application/json");
			 * Response responseFromGenerateToken =
			 * request.body(Pojo.logincred()).post(URLs.loginEndpoint);
			 * 
			 * responseFromGenerateToken.prettyPrint();
			 * 
			 * 
			 * 
			 * int statusCode = responseFromGenerateToken.getStatusCode();
			 * System.out.println(statusCode); //Extracting token from response String
			 * jsonString = responseFromGenerateToken.getBody().asString(); String
			 * tokenGenerated = JsonPath.from(jsonString).get("token");
			 * 
			 * request.header("Authorization","Bearer "+tokenGenerated).header(
			 * "Content-Type","application/json"); allResponses.add(jsonString);
			 * System.out.println(allResponses);
			 */
		}
		
	
	

	@When("Admin calls Post Https method  with valid endpoint")
	public void admin_calls_post_https_method_with_valid_endpoint() {
	   
	}

	@Then("Admin receives {int} created with auto generated token")
	public void admin_receives_created_with_auto_generated_token(Integer int1) {
		
		
		
		//int statusCode=	responseFromGenerateToken.getStatusCode();
		
		
		//int statusCode=RestAssured.given().get().statusCode();
		//System.out.println(statusCode);
		//Assert.assertEquals(statusCode ,200);
		//System.out.println("Validation Sucessful");
		//String statusCode = null;
		// RestAssured.responseSpecification.statusCode(200);
		//int statusCode = response.then().extract().statusCode();
		//Assert.assertEquals(statusCode ,200);
		//System.out.println(RestAssured.responseSpecification);
		/*
		 * int statuscode = response.ge if(statuscode == 201) {
		 * response.getStatusLine(); }
		 */
	}
}
