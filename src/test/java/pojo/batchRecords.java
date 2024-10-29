package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class batchRecords {
	

	
	private String programName;
	private String batchName;
	private String description;
    private String noOfClass;
    
	public batchRecords(String programName, String batchName, String description, String noOfClass) {
		super();
		this.programName = programName;
		this.batchName = batchName;
		this.description = description;
		this.noOfClass = noOfClass;
	}
  
    

}