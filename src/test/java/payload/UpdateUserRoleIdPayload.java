package payload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import stepdefinition.ExcelReader_Rest;

public class UpdateUserRoleIdPayload {
	private List<String>userRoleList;
	static String Jsonbody;
	

	public List<String> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<String> userRoleList) {
		this.userRoleList = userRoleList;
	}


	 
	 
	 public static  String userroleID() throws InvalidFormatException, IOException {
			
			/*
			 * UpdateUserRoleIdPayload updateUserRoleId = new UpdateUserRoleIdPayload();
			 * updateUserRoleId.setUserRoleList(null);
			 * 
			 * List<Map<String, String>>map = (List<Map<String, String>>)
			 * ExcelReader_Rest.getData(URLs.Excelpath,"Sheet 4 - Table 1-1")
			 * for(Map<String, String> row : map) {
			 * 
			 * String valueOfString = row.get("String");
			 * 
			 * UpdateUserRoleIdPayload putpayload = new UpdateUserRoleIdPayload(); if
			 * (putpayload.getUserRoleList() == null) { putpayload.setUserRoleList(new
			 * ArrayList<>()); }
			 * 
			 * putpayload.getUserRoleList().add(valueOfString);
			 * 
			 * ObjectMapper objMap = new ObjectMapper(); Jsonbody =
			 * objMap.writerWithDefaultPrettyPrinter().writeValueAsString(putpayload);
			 * System.out.println(Jsonbody); } 
			 */
		 return Jsonbody;
}
}