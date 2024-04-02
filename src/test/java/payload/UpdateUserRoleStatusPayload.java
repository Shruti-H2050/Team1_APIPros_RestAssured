package payload;

import java.io.IOException;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class UpdateUserRoleStatusPayload {
	private static String roleId;
	private static String userRoleStatus;
	private static String Jsonbodyuserrole;
	
	
	
	
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		UpdateUserRoleStatusPayload.roleId = roleId;
	}
	public String getUserRoleStatus() {
		return userRoleStatus;
	}
	public void setUserRoleStatus(String userRoleStatus) {
		UpdateUserRoleStatusPayload.userRoleStatus = userRoleStatus;
	}
	
    public static  String userrolestatus() throws InvalidFormatException, IOException {
		
		//List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.Excelpath,"Sheet 4 - Table 1-1");
		//for (Map<String, String> row : map) {
	
	
    	UpdateUserRoleStatusPayload putpayloadrolestatus= new UpdateUserRoleStatusPayload();
	putpayloadrolestatus.setRoleId("R01");
	putpayloadrolestatus.setUserRoleStatus("Active");
	
	ObjectMapper om = new ObjectMapper();
    Jsonbodyuserrole=om.writerWithDefaultPrettyPrinter().writeValueAsString(putpayloadrolestatus);
    System.out.println(Jsonbodyuserrole);
    return Jsonbodyuserrole;	
	    }
    
    
    public static void main(String[] args) throws InvalidFormatException, IOException {
    	userrolestatus() ;
    }
}
