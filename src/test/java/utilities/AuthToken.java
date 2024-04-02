package utilities;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepdefinition.ExcelReader_Rest;
public class AuthToken {
static String token;
	
	public  static  String getBearerToken() throws InvalidFormatException, IOException {
		

		List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.Excelpath, "Sheet 4 - Table 1-1");
		for (Map<String, String> row : map) {
			String mypwd = row.get("password");
			String userLoginEmailId = row.get("userLoginEmailId");
			RestAssured.baseURI = URLs.BaseURL;
			RequestSpecification request = RestAssured.given();
		
				String userInfoJson = "{" +
						"\"password\": \"" + mypwd + "\"," +
						"\"userLoginEmailId\": \"" + userLoginEmailId + "\"}" ;		
			request.header("Content-Type","application/json");
			Response responseFromGenerateToken = request.body(userInfoJson).post(URLs.loginEndpoint);
			//responseFromGenerateToken.prettyPrint();
			
			//Extracting token from response
			String jsonString = responseFromGenerateToken.getBody().asString();
			token = JsonPath.from(jsonString).get("token");
			//request.header("Authorization","Bearer "+tokenGenerated).header("Content-Type","application/json");
		
	}
		return token;
	
	}
}
