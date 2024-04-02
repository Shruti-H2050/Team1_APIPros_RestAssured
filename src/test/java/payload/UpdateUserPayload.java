package payload;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import stepdefinition.ExcelReader_Rest;

public class UpdateUserPayload {
	 //admin info
		private String userComments;
		private String userEduPg;
		private String userEduUg;
		private String userFirstName;
		private String userLastName;
		private String userMiddleName;
		private String userLinkedinUrl;
		private int phonenumber;
		private String userLocation;
		private String userTimeZone;
		private String userVisaStatus;
		
		//userrolestatus
		private String roleId;
		private String userRoleStatus;
		
		//jsonbody
		static String Jsonbody;
		static String  Jsonbodyuserrole;
		
		public String getUserComments() {
			return userComments;
		}
		public void  setUserComments(String userComments) {
			this.userComments = userComments;
		}
		public String getUserEduPg() {
			return userEduPg;
		}
		public void setUserEduPg(String userEduPg) {
			this.userEduPg = userEduPg;
		}
		public String getUserEduUg() {
			return userEduUg;
		}
		public void setUserEduUg(String userEduUg) {
			this.userEduUg = userEduUg;
		}
		public String getUserFirstName() {
			return userFirstName;
		}
		public void setUserFirstName(String userFirstName) {
			this.userFirstName = userFirstName;
		}
		public String getUserLastName() {
			return userLastName;
		}
		public void setUserLastName(String userLastName) {
			this.userLastName = userLastName;
		}
		public String getUserMiddleName() {
			return userMiddleName;
		}
		public void setUserMiddleName(String userMiddleName) {
			this.userMiddleName = userMiddleName;
		}
		public String getUserLinkedinUrl() {
			return userLinkedinUrl;
		}
		public void setUserLinkedinUrl(String userLinkedinUrl) {
			this.userLinkedinUrl = userLinkedinUrl;
		}
		public int getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(int phonenumber) {
			this.phonenumber = phonenumber;
		}
		public String getUserLocation() {
			return userLocation;
		}
		public void setUserLocation(String userLocation) {
			this.userLocation = userLocation;
		}
		public String getUserTimeZone() {
			return userTimeZone;
		}
		public void setUserTimeZone(String userTimeZone) {
			this.userTimeZone = userTimeZone;
		}
		public String getUserVisaStatus() {
			return userVisaStatus;
		}
		public void setUserVisaStatus(String userVisaStatus) {
			this.userVisaStatus = userVisaStatus;
		}
		
		//userrolestatus getters n setters
		public String getRoleId() {
			return roleId;
		}
		
		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}
		
		public String getUserRoleStatus() {
			return userRoleStatus;
		}
		
		public void setUserRoleStatus(String userRoleStatus) {
			this.userRoleStatus = userRoleStatus;
		}
		
		
		
		public static  String admininfo() throws InvalidFormatException, IOException {
			
			List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.ExcelpathforUpdateUser,"Sheet 1");
			for (Map<String, String> row : map) {
				
				String usercomments = row.get("userComments");
				String userEduPg= row.get("userEduPg");
				String userEduUg = row.get("userEduUg");
				String userFirstName= row.get("userFirstName");
				String userLastName = row.get("userLastName");
				String userMiddleName= row.get("userMiddleName");
				String userLinkedinUrl= row.get("userLinkedinUrl");
				String userLocation = row.get("userLocation");
				String userTimeZone= row.get("userTimeZone");
				int phonenumber=Integer.parseInt(row.get("phonenumber"));  
			
				UpdateUserPayload putpayload= new UpdateUserPayload();
			putpayload.setUserComments(usercomments);
			putpayload.setUserEduPg(userEduPg);
			putpayload.setUserEduUg(userEduUg);
			putpayload.setUserFirstName(userFirstName);
			putpayload.setUserLastName(userLastName);
			putpayload.setUserMiddleName(userMiddleName);
			putpayload.setUserLinkedinUrl(userLinkedinUrl);
			putpayload.setUserLocation(userLocation);
			putpayload.setUserTimeZone(userTimeZone);
			putpayload.setPhonenumber(phonenumber);
		
			ObjectMapper om = new ObjectMapper();
	        Jsonbody=om.writerWithDefaultPrettyPrinter().writeValueAsString(putpayload);
	        System.out.println(Jsonbody);	
			}
	        return Jsonbody;		

		}
			
		
		/*public static String userrolestatus() throws JsonProcessingException {
			
			UserPutPayload12 putpayloadrolestatus= new UserPutPayload12();
			putpayloadrolestatus.setRoleId("etet");
			putpayloadrolestatus.setUserRoleStatus("ewete");
			
			ObjectMapper om = new ObjectMapper();
	        Jsonbodyuserrole=om.writerWithDefaultPrettyPrinter().writeValueAsString(putpayloadrolestatus);
	        System.out.println(Jsonbodyuserrole);
	        return Jsonbodyuserrole;	
			}*/
		 
		public static void main(String[] args) throws InvalidFormatException, IOException {
			admininfo() ;
			//userrolestatus();

}
}
