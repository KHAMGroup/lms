package models;

import java.util.Date;

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
	public String caseNumber;
	public Date dateReceived;
	public String caseNote;
	public int receivedByEmployee; //employee id#
	
	
	//services
	public String[]	testNumber = new String[15];
	
	
	
	

}
