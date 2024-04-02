package utilities;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.UserLoginPayload;
import stepdefinition.ExcelReader_Rest;
public class BearerToken {
static String Jsonbody;
	
	public static String  bearertoken() throws InvalidFormatException, IOException {
		
		List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.Excelpath, "Sheet 4 - Table 1-1");
		for (Map<String, String> row : map) {
			String mypwd = row.get("password");
			String userLoginEmailId = row.get("userLoginEmailId");
	
			UserLoginPayload  ulp= new UserLoginPayload();
			ulp.setUserLoginEmailId(userLoginEmailId);
			ulp.setPassword(mypwd);
			
			
			ObjectMapper om = new ObjectMapper();
	        Jsonbody=om.writerWithDefaultPrettyPrinter().writeValueAsString(ulp);
	        System.out.println(Jsonbody);
		 }
		
		Response response=	RestAssured.given().baseUri(URLs.BaseURL)
						.header("Content-Type","application/json")
						.body(Jsonbody)
						.when()
						.post(URLs.loginEndpoint);
		  System.out.println(response.asString());
		
		  String token=response.jsonPath().get("token").toString();
	      //String status=response.jsonPath().get("status").toString(); 
	        
	     // System.out.println(token);
		//  System.out.println(status);
		 return token;
	     }
	
	
	public static void main(String[] args) throws InvalidFormatException, IOException {
		bearertoken();
		
}
}
