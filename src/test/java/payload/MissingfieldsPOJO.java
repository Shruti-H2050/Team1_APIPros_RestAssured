package payload;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import stepdefinition.ExcelReader_Rest;

public class MissingfieldsPOJO {
static String Jsonbody;
	
	private String programName;
	private String programStatus;
	
	static SaveProgramPOJO programpayload;
	static String jsonBody;
	
	public static void  programmodule() throws InvalidFormatException, IOException {
		
		
		//List<Map<String, String>>map = ExcelReaderRest.getData(URLs.PgmModuleExcelpath,"missingfields");

		List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.PgmModuleExcelpath,"missingfields");
		for (Map<String, String> row : map) {

			String Progname= row.get("programName");
			String Progstatus = row.get("programStatus");
			
		
		 programpayload= new SaveProgramPOJO();
		 programpayload.setProgramName(Progname);
		 programpayload.setProgramStatus(Progstatus);
	
		}
		   		

	}
	
	public static String getJsonString () throws Exception {
		programmodule();
		ObjectMapper om = new ObjectMapper();
		try {
			jsonBody = om.writerWithDefaultPrettyPrinter().writeValueAsString(programpayload);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   System.out.println(jsonBody);	
		    
	    return jsonBody;
	}
	
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramStatus() {
		return programStatus;
	}
	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}
	

}
