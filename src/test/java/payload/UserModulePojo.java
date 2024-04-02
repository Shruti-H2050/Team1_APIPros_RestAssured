
  package payload;
  import java.util.List;
  
  public class UserModulePojo {
	  private String userComments;
	  private String userEduPg;
	  private String userEduUg;
	  private String userFirstName;
	  private String userLastName;
	  private String userLinkedinUrl;
	  private String userLocation;
	  private UserModuleUserLoginPojo userLogin;
	  private String userMiddleName;
	  private int userPhoneNumber;
	 
	private List<UserModuleUserRoleMapsPojo> userRoleMaps;
	  private String userTimeZone;
	  private String userVisaStatus;
	  
	  
	  
	public String getUserComments() {
		return userComments;
	}
	public void setUserComments(String userComments) {
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
	public String getUserLinkedinUrl() {
		return userLinkedinUrl;
	}
	public void setUserLinkedinUrl(String userLinkedinUrl) {
		this.userLinkedinUrl = userLinkedinUrl;
	}
	public String getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	 public UserModuleUserLoginPojo getUserLogin() {
			return userLogin;
		}
	public void setUserLogin(UserModuleUserLoginPojo userLogin) {
			this.userLogin = userLogin;
		}
	public String getUserMiddleName() {
		return userMiddleName;
	}
	public void setUserMiddleName(String userMiddleName) {
		this.userMiddleName = userMiddleName;
	}
	public int getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(int userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
		
	
	public List<UserModuleUserRoleMapsPojo> getUserRoleMaps() {
		return userRoleMaps;
	}
	public void setUserRoleMaps(List<UserModuleUserRoleMapsPojo> userRoleMaps) {
		this.userRoleMaps = userRoleMaps;
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
	
  }
 