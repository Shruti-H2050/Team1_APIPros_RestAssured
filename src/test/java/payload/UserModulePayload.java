package payload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import stepdefinition.ExcelReader_Rest;

public class UserModulePayload {
	static String Jsonbody;
	public static void main(String[] args) {
		
		
	}	
		
		public static String UserModulePostRequestBody() throws IOException  {
			
			List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.ExcelcreateNewUser,"Sheet 4");
			for (Map<String, String> row : map) {
				
				String usercomments = row.get("userComments");
				String userEduPg= row.get("userEduPg");
				String userEduUg = row.get("userEduUg");
				String userFirstName= row.get("userFirstName");
				String userLastName = row.get("userLastName");
				String userLinkedinUrl = row.get("userLinkedinUrl");
				String userLocation = row.get("userLocation");
				String loginStatus =row.get("loginStatus");
				String userpassword = row.get("userpassword");
				String userLoginEmail = row.get("userLoginEmail");
				String userMiddleName = row.get("userMiddleName");
				int userPhoneNumber = Integer.parseInt(row.get("userPhoneNumber"));
				String roleId = row.get("roleId");
				String userRoleStatus = row.get("userRoleStatus");
				String userTimeZone = row.get("userTimeZone");
				String userVisaStatus = row.get("userVisaStatus");
				
				UserModulePojo userModulePojo = new UserModulePojo();
				
				userModulePojo.setUserComments(usercomments);
				userModulePojo.setUserEduPg(userEduPg);
				userModulePojo.setUserEduUg(userEduUg);
				userModulePojo.setUserFirstName(userFirstName);
				userModulePojo.setUserLastName(userLastName);
				userModulePojo.setUserLinkedinUrl(userLinkedinUrl);
				userModulePojo.setUserLocation(userLocation);
				
				UserModuleUserLoginPojo userModuleUserLogin = new UserModuleUserLoginPojo();
				
				userModuleUserLogin.setLoginStatus(loginStatus);
				userModuleUserLogin.setPassword(userpassword);
				userModuleUserLogin.setUserLoginEmail(userLoginEmail);
				
				userModulePojo.setUserLogin(userModuleUserLogin);
				userModulePojo.setUserMiddleName(userMiddleName);
				userModulePojo.setUserPhoneNumber(userPhoneNumber);
				
				UserModuleUserRoleMapsPojo userModuleUserRoleMaps = new UserModuleUserRoleMapsPojo();
				userModuleUserRoleMaps.setRoleId(roleId);
				userModuleUserRoleMaps.setUserRoleStatus(userRoleStatus);
				
				List<UserModuleUserRoleMapsPojo> allRoles = new ArrayList();
				allRoles.add(userModuleUserRoleMaps);
				userModulePojo.setUserRoleMaps(allRoles);
				
				userModulePojo.setUserTimeZone(userTimeZone);
				userModulePojo.setUserVisaStatus(userVisaStatus);
				
				
			ObjectMapper om = new ObjectMapper();
	        Jsonbody=om.writerWithDefaultPrettyPrinter().writeValueAsString(userModulePojo);
	        System.out.println(Jsonbody);	
			}
	        return Jsonbody;		

		}

		
		
		
	}
	

