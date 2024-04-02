package payload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import endpoints.URLs;
import io.restassured.RestAssured;
import stepdefinition.ExcelReader_Rest;

public class UserModuleUpdateUserLoginStatusPayload {

	UserModuleUpdateUserLoginStatusPayload userModuleUpdateUserLoginStatusPayload = new UserModuleUpdateUserLoginStatusPayload();
	
	static String Jsonbody;
	
	public static String UserModulePutRequestBody() throws IOException  {
		
		List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.Excelpath,"Sheet 4 - Table 1-1");
		for (Map<String, String> row : map) {
			String updateloginstatus = row.get("loginStatus");
			String updatepassword = row.get("userpassword");
			String updateRoleId = row.get("roleId");
			String updateStatus = row.get("userRoleStatus");
			String updateLoginEmail = row.get("userLoginEmail");
			
			
			PutUserLoginStatusPojo updateUserLoginStatusPojo = new PutUserLoginStatusPojo();
			updateUserLoginStatusPojo.setLoginStatus(updateloginstatus);
			updateUserLoginStatusPojo.setPassword(updatepassword);
			
			PutRoleIdUserLoginStatusPojo updateRoleIdUserLoginStatus =new PutRoleIdUserLoginStatusPojo();
			List<PutRoleIdUserLoginStatusPojo> updateAllRoleId = new ArrayList();
			updateAllRoleId.add(updateRoleIdUserLoginStatus);
			updateUserLoginStatusPojo.setRoleIds(updateAllRoleId);
			updateRoleIdUserLoginStatus.setRoleidvariable(updateRoleId);
			
			updateUserLoginStatusPojo.setStatus(updateStatus);
			updateUserLoginStatusPojo.setUserLoginEmail(updateLoginEmail);
		}
		RestAssured.given().log().all().body(Jsonbody).post();
		return Jsonbody;
			
}
	
}
