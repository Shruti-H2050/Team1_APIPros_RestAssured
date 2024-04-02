package payload;

import endpoints.URLs;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import stepdefinition.ExcelReader_Rest;


public class UpdateProgramByIdPOJO {
static String Jsonbody;
	
	private String programName;
	private String programDescription;
	private String programStatus;
	
	static UpdateProgramByIdPOJO programpayload;
	static String jsonBody;
	
	public static void  programmodule() throws InvalidFormatException, IOException {
		
		
	//	List<Map<String, String>>map = ExcelReaderRest.getData(URLs.PgmModuleExcelpath,"updateprogrambyid");
		
		List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.PgmModuleExcelpath,"updateprogrambyid");
		for (Map<String, String> row : map) {
			
			String Progdesc = row.get("programDescription");
			String Progname= row.get("programName");
			String Progstatus = row.get("programStatus");
			
		
		 programpayload= new UpdateProgramByIdPOJO();
		 programpayload.setProgramDescription(Progdesc);
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
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	public String getProgramStatus() {
		return programStatus;
	}
	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}
	
}
