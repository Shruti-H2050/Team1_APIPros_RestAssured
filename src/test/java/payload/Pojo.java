package payload;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import endpoints.URLs;
import stepdefinition.ExcelReader_Rest;

public class Pojo {
	static String userLoginEmailId;
	static String mypwd ;
	public static String logincred() throws IOException {
    	UserLoginPayload  ulp= new UserLoginPayload();
 	 	//Datadriven dd = new Datadriven();
 		/*System.out.println(dd.getdata("Login credentials"));
 		ArrayList<String> al=dd.getdata("Login credentials");
 		System.out.println(al.get(1));*/
    	
    	List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.Excelpath, "Sheet 4 - Table 1-1");
		for (Map<String, String> row : map) {
			 mypwd = row.get("password");
			 userLoginEmailId = row.get("userLoginEmailId");
 	
		}
			ulp.setUserLoginEmailId(userLoginEmailId);
 	//	System.out.println(al.get(2));
 		ulp.setPassword(mypwd);
 		
 		ObjectMapper om = new ObjectMapper();
        String Jsonbody=om.writerWithDefaultPrettyPrinter().writeValueAsString(ulp);
		/*
		 * System.out.println("Ephrathah "); System.out.println(Jsonbody); return
		 * Jsonbody;
		 */
        return Jsonbody;
}
}
	