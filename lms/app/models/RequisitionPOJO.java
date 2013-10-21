package models;

import java.util.Date;

import play.data.validation.Constraints.*;

public class RequisitionPOJO {
	
	//case data
	public String subjectFirstName;
	public String subjectLastName;
	public String otherIdNumber;
//	public boolean sampleBlood;
//	public boolean sampleUrine;
//	public boolean sampleOther;
//	public String sampleOtherText;
	public Date dateCollected;
	
	@Required
	public String caseNumber;
	public Date dateReceived;
	public String caseNote;
	
	
	public String receivedByEmployee; //employee id#
	
	
	//services
	public int[] testNumber = new int[15];
	
	public RequisitionPOJO(){
		
	}
	
	
	
	

}
