package payload;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import stepdefinition.ExcelReader_Rest;

public class BatchPutPayload {

	private String batchDescription;
    private int batchId;
	private String batchName;
	private int batchNoOfClasses;
	private String batchStatus;
    private int programId;
    private String programName;

	
	static BatchPutPayload  programpayload;
	static String jsonBody;
	
    
	public static void  programmodule() throws InvalidFormatException, IOException {
		

		//List<Map<String, String>>map = ExcelReaderRest.getData(URLs.Excelpath,"putbatch");
		
		List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.BatchModuleExcelpath,"putbatch");
		for (Map<String, String> row : map) {
			
			String batchDescription = row.get("batchDescription");
			String batchName= row.get("batchName");
			int batchNoOfClasses= Integer.parseInt(row.get("batchNoOfClasses")); 
			String batchStatus= row.get("batchStatus");
			int programId = Integer.parseInt(row.get("programId")); 
			String programName=row.get("programName");
			int batchId=Integer.parseInt(row.get("batchId"));
			
			programpayload=new BatchPutPayload ();
				
			programpayload.setBatchDescription(batchDescription);
			programpayload.setBatchId(batchId);
			programpayload.setBatchName(batchName);
			
			programpayload.setBatchNoOfClasses(batchNoOfClasses);
			programpayload.setBatchStatus(batchStatus);
			programpayload.setProgramId(programId);
			programpayload.setProgramName(programName);
			
			
		}}
		

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
	
		
		
		 public String getBatchDescription() {
		return batchDescription;
	}
	public void setBatchDescription(String batchDescription) {
	//	batchDescription = Concatenate (batchDescription + Math.random());
		this.batchDescription = batchDescription;
	}
	

	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public int getBatchNoOfClasses() {
		return batchNoOfClasses;
	}
	public void setBatchNoOfClasses(int batchNoOfClasses) {
		this.batchNoOfClasses = batchNoOfClasses;
	}
	public String getBatchStatus() {
		return batchStatus;
	}
	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}
	public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}













}

