package payload;

public class UserLoginPayload {
	private String userLoginEmailId;
	private String password;
	
	
	public String getUserLoginEmailId() {
		return userLoginEmailId;
	}
	
	public String setUserLoginEmailId(String userLoginEmailId1) {
	     return	 userLoginEmailId = userLoginEmailId1;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String setPassword(String password1) {
		return password = password1;
	}
}
