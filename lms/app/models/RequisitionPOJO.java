package models;

import java.util.Date;

public class RequisitionPOJO {
	
	//case data
	public String subjectFirstName;
	public String subjectLastName;
	public String otherIdNumber;
	public boolean sampleBlood;
	public boolean sampleUrine;
	public boolean sampleOther;
	public String sampleOtherText;
	public Date dateCollected;
	public String caseNumber;
	public Date dateReceived;
	public String caseNote;
	public String receivedByEmployee;
	
	//services
	public boolean testAlcohol;
	public boolean testFlouridePreservative;
	public boolean testABOBloodTyping;
	public boolean testAlcoholDUITestPanel; //includes previous 3 tests.
	public boolean testDrugAnalysis;
	public boolean testQualitative;
	public boolean testQuantitative;
	public String testQuantitativeForText;
	public boolean testTestimonyReservation;
	public String testTestomonyLocation;
	public Date testTestimonyDate;
	public boolean testCaseReview;
	public boolean testWrittenReport;
	public boolean testOtherReview;
	public String testOtherReviewText;
	
	
	
	

}
