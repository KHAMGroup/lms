package controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import views.html.helper.form;
import models.*;

@Security.Authenticated(Avocado.class)
public class CaseController extends Controller {
	
    public static Result search(String searchString) {
		List<CaseEntityObject> casesFound = new LinkedList<CaseEntityObject>();
		if(SearchTools.isFormattedFirstAndLast(searchString)){
			String[] firstAndLast = SearchTools.getFormattedFirstAndLast(searchString);
			String first = firstAndLast[0];
			String last = firstAndLast[1];
			casesFound.addAll(CaseEntityObject.findBySubjectFirstAndLastName(first, last));
		}
		else if(SearchTools.isFirstOrLast(searchString)){
			casesFound.addAll(CaseEntityObject.findBySubjectFirstOrLastName(searchString));
		}
		return MainController.showDashboardWithCases(casesFound);
    }

    @Transactional
    public static Result createCase(int clientID) {
    	
    	Client c = Client.findByClientNumber(clientID);
    	if(c == null){
    		return forbidden("\nThe client: " + clientID + " could not be found\n");
    	}else{
    		//get list of tests
    		List<TestEntityObject> tests = TestEntityObject.getAllTests();
    		
    		//create form object
        	Form<RequisitionPOJO> theForm = form(RequisitionPOJO.class);
        	RequisitionPOJO req = new RequisitionPOJO();
        	req.clientID = "" + clientID;
        	theForm = theForm.fill(req);
        	
        	return ok(views.html.cases.create_case.render(theForm, tests, null));
    	}
    	
    }

    @Transactional
    public static Result saveCase() {
    	boolean errorsFound = false;
    	Employee emp;
    	int empID;
    	
    	Client cli;
    	int cliID = -1;
    	List<TestEntityObject> tests = TestEntityObject.getAllTests();
    	Form<RequisitionPOJO> theForm = form(RequisitionPOJO.class).bindFromRequest();
    	List<String> err = new LinkedList<String>(); //used to hold a list of custom errors (if any).
    	//make sure everything is peachy with the form.
    	if(theForm.hasErrors()){
    		
    		err.add("There are errors with the submitted form data");
    		return badRequest(views.html.cases.create_case.render(theForm, tests, err));
    	}else{
	    	
	    	RequisitionPOJO req = theForm.get();
	    	//check if caseNumber is unique
	    	CaseEntityObject newCase = CaseEntityObject.findByCaseNumber(req.caseNumber);
	    	if(newCase.getCaseNumber() != null && newCase.getCaseNumber().length() > 0){
	    		//a case with this case# already exists
	    		err.add("Case#: " + req.caseNumber + " already exists.");
	    		errorsFound = true;
	    		return badRequest(views.html.cases.create_case.render(theForm, tests, err));
	    	}else{
	    		//good to proceed.
	    		newCase.setCaseNumber(req.caseNumber);
	    	}
	    	
	    	if(req.receivedByEmployee.length() > 0){
	    		//check if it's a valid #
	    		try{
	    			empID = Integer.parseInt(req.receivedByEmployee);
	    		}catch (Exception ex){
	    			err.add("Receieved by employee id# can only contain digits");
	    			errorsFound = true;
	    			return badRequest(views.html.cases.create_case.render(theForm, tests, err));
	    		}
	    		
	    		//check if receivedByEmployee is valid #
	    		
	    		emp = Employee.findById(empID);
	    		if((emp != null) && (emp.getEmployeeNumber() == empID)){
	    			
	    		}else{
	    			err.add("Employee: " + empID + " was not found.");
	    			errorsFound = true;
	    			return badRequest(views.html.cases.create_case.render(theForm, tests, err));
	    		}
	    	}else{
	    		emp = null;
	    	}
	    	
	    	
	    	
	    	//parse clientID from form.
	    	try{
	    		cliID = Integer.parseInt(req.clientID);
	    	}catch (Exception ex){
	    		err.add("Client: " + req.clientID + " not found.");
	    		errorsFound = true;
	    		return badRequest(views.html.cases.create_case.render(theForm, tests, err));
	    	}
	    	
	    	//link client to case.
	    	cli = Client.findByClientNumber(cliID);
	    	newCase.setClient(cli);
	    	List<CaseTest> theTests = new LinkedList<CaseTest>();
	    	CaseTest theTest;
	    	for(int testNum : req.testNumber){
	    		if(testNum != -1){
	    			TestEntityObject t = TestEntityObject.findByTestNumber(testNum);
	    			theTest = new CaseTest();
//	    			theTest.setBilled(false); //mark this new caseTest as not billed
	    			theTest.setTest(t); //link the test to the caseTest
	    			theTests.add(theTest);
	    			//theTest.setCaseEntity(newCase);//add the caseTest to the case
	    			
	    			
	    		}
	    	}
	    	newCase.setCaseTests(theTests);
	    	
	    	
	    	//fill in other standard fields for the case from the form.
			newCase.setSubjectFirstname(req.subjectFirstName);
			newCase.setSubjectLastname(req.subjectLastName);
			newCase.setReceivedDate(req.dateReceived);
			newCase.setDateCollected(req.dateCollected);
			newCase.setReceivedByEmployee(emp);
			newCase.setSampleType(req.sampleType);
			//newCase.setEmailInvoiceOk(cli.getEmailInvoiceOk());
			newCase.setEmailResultsOk(cli.getEmailReportOk());
			newCase.setAllTasksCompleted(false);
			
			if(req.otherIdNumber != null && (req.otherIdNumber.length() > 0)){
				newCase.setOtherIdNumber(req.otherIdNumber);
			}
			
			if(req.caseNote != null && (req.caseNote.length() > 0)){
				Comment comment = new Comment();
				comment.setCommentText(req.caseNote);
				newCase.setCaseNote(comment);
			}
			

			for(CaseTest t : theTests){
				t.setCaseEntity(newCase);
//				JPA.em().persist(t);
			}
			newCase.save();
	    	//TODO: remove this test stuff, and actually redirect to a confirmation page or dashboard.
	    	CaseEntityObject theCase = CaseEntityObject.findByCaseNumber(req.caseNumber);
	    	if(theCase != null){
		    	if(theCase.getCaseNumber() != null){
		    		String testList = "";
		    		for(CaseTest ct : theCase.getCaseTests()){
		    			testList += " " + ct.getTest().getTestName();
		    		}
		    		return ok("Case #:" + theCase.getCaseNumber() +
		    				"\n# of tests: " + theCase.getCaseTests().size() +
		    				"\n the tests: " + testList);
		    	}
	    	}
	    	return ok("newly created case wasn't persisted");
	    	
	    	
	    	//return redirect(routes.MainController.returnToDashboard());
    	}
    }
}
