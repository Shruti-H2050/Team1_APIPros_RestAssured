package endpoints;

public class URLs {

	public static String BaseURL ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";

	public static String loginEndpoint = "/login";
	public static String logoutEndpoint ="/logoutlms";
	public static String Excelpath = "./src/test/resources/TestData/LoginCredentials2.xlsx";
	public static String ExcelpathforUpdateUser = "./src/test/resources/TestData/UpdateUser.xlsx";
	public static String ExcelcreateNewUser = "./src/test/resources/TestData/UpdateUser.xlsx/CreateNewUser";
	public static String createUserwithRole = "/users/roleStatus";
	public static String  getAllUsers = "/users";
	public static String getAllRoles = "users/roles";
	public static String getUserInfoById = "users/U134";
	public static String updateUserLoginStatus = "/users/userLogin/U177";
	public static String getUsersWithRole ="/roles";
	public static String countActiveInactiveUsers ="/users/byStatus";
	public static String getAllActiveUsers = "/users/activeUsers";
	public static String getUserswithBatchId = "users/programBatch/8455";
	public static String getUserswithPgmId ="/users/programs/16208";
	public static String getUserByRoleId = "/users/roles/R01";
	public static String getUserByRoleIdV2 = "/v2/users";
	public static String updateUser ="/users/U177";
	public static String UpdateUserrolestus = "/users/roleStatus/U177";
	public static String updateUserRolePrgmBatchStatu = "/users/roleProgramBatchStatus/{userId}";
	
	//program Module
	
	public static String PgmModuleExcelpath = "./src/test/resources/TestData/ProgramTestsData.xlsx";
	public static String saveProgram = "/saveprogram";
	public static String invalsaveProgram = "/savegram";
	public static String allPrograms = "/allPrograms";
	public static String progid = "/programs/";
	public static String progwithusers = "/allProgramsWithUsers";
	public static String putprogramid = "/putprogram/";
	public static String putprogramname = "/program/";
	public static String delprogid = "/deletebyprogid/16524";
	public static String delprogname = "/deletebyprogname/SoftwareTesting236";
	
	//Batch module
	
	public static String postcreateendpoint="/batches";
	public static String getallbatchendpoint="/batches";
	public static String getbatchidendpoint="/batches/batchId/";
	public static String getbatchnameendpoint="/batches/batchName/";
	public static String getbatchprogramidendpoint="/batches/program/16241";
	public static String updatebatchidendpoint="/batches/";
	public static String deletebatchidendpoint="/batches/";
	public static String BatchModuleExcelpath = "./src/test/resources/TestData/BatchTestsData.xlsx";		

	public static String invalidpostcreateendpoint="/batches";
	public static String invalidbatchid="/batches/batchId/";

	//public static String 
	
	/*public static String username = "Numpy@gmail.com";
	public static String password ="userAPI";
		//public static String BaseUrl = "https://userapi-8877aadaae71.herokuapp.com/uap" ;
	
	
	public  static String Getallusers = "/users";
		public static String CreateUser = "/createusers";
		//public static String Excelpath = "./src/test/resources/TestData/testdata.xlsx";
		public static String GetUserById = "/user/{userId}";
		public static String GetUserByFirstName = "/users/username/{userFirstName}";
		public static String UpdateUser = "/updateuser/{userId}";
		public static String DeleteUserByFirstName = "/deleteuser/username/{userfirstname}";
		public static String DeleteUserByUserId = "/deleteuser/{userId}\r\n";
		
		//Invalid url and endpoint
		
		public static String InvalidUrl ="https://userapi-8877aadaae71.herokuapp.com";
		public static String Invalid_endpoint = "/ab";
	
	
	public static String BaseUrl = "https://reqres.in/";
	public static String createUser = "api/users/";*/
	//public static String Excelpath = "./src/test/resources/TestData/restPost.xlsx";
}
