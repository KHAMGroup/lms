package models;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

//import java.sql.Date;

import play.data.validation.Constraints.*;

public class RequisitionPOJO {
	
	//case data
	public String clientID; //client id#
	public String subjectFirstName;
	public String subjectLastName;
	public String otherIdNumber;
	public String sampleType;
	public Date dateCollected;
	
	@Required
	@MaxLength(7)
	public String caseNumber;
	public Date dateReceived;
	public String caseNote;
	
	
	public String receivedByEmployee; //employee id#
	
	
	//services
	public List<Integer> testNumber;
	
	
	public RequisitionPOJO(){
		
	}
	
	
	
	

}
