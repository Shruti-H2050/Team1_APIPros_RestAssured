package payload;

import java.util.List;

public class PutUserLoginStatusPojo {
	
	private String loginStatus;
	 private String password;
	 private List<PutRoleIdUserLoginStatusPojo> roleIds;
	 private String status;
	 private String userLoginEmail;

		 public String getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<PutRoleIdUserLoginStatusPojo> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<PutRoleIdUserLoginStatusPojo> roleIds) {
		this.roleIds = roleIds;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserLoginEmail() {
		return userLoginEmail;
	}
	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}
		
		
		
		
		
		

}
