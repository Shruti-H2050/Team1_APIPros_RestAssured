package payload;

public class Program {
	private String programName;
	private String programDescription;
	private String programStatus;
	
	
	public  Program(String programName, String programDescription,String programStatus) {
		setProgramName(programName);
		setProgramDescription(programDescription);
		setProgramStatus(programStatus);
	}
	public String getProgramName()
	
	{
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


