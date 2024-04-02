package payload;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import endpoints.URLs;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import stepdefinition.ExcelReader_Rest;

public class batchespojo {
	private  String batchDescription;
	private  String batchName;
	private   int batchNoOfClasses;
	private  String batchStatus;
    private   int programId;

  static  batchespojo newprogram;
  static String jsonBody;
    
    
   
    public static  void programbatch() throws InvalidFormatException, IOException {


    	
	//	List<Map<String, String>>map = ExcelReaderRest.getData(URLs.Excelpath,"create program");
    	
		List<Map<String, String>>map = ExcelReader_Rest.getData(URLs.BatchModuleExcelpath,"createprogram");
		for (Map<String, String> row : map) {
			
			String batchdescription = row.get("batchDescription");
			String batchname= row.get("batchName");
			int batchNoOfclasses= Integer.parseInt(row.get("batchNoOfClasses")); 
			String batchstatus= row.get("batchStatus");
			int programid = Integer.parseInt(row.get("programId")); 
			

			 newprogram = new  batchespojo();

			 newprogram.setBatchDescription(batchdescription);
			 newprogram.setBatchName(batchname);
			 newprogram.setBatchNoOfClasses(batchNoOfclasses);
			 newprogram.setBatchStatus(batchstatus);
			 newprogram.setProgramId(programid);
			 
			 
		}} 
			 
    public static String getJsonString () throws Exception {
    	programbatch();
    	ObjectMapper om = new ObjectMapper();
		try {
			jsonBody = om.writerWithDefaultPrettyPrinter().writeValueAsString(newprogram);
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
			this.batchDescription = batchDescription;
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


		}

