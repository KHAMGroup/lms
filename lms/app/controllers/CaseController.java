package controllers;

import java.util.LinkedList;
import java.util.List;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
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
    public static Result createCase() {
    	List<TestEntityObject> tests = TestEntityObject.getAllTests();
    	Form<RequisitionPOJO> theForm = form(RequisitionPOJO.class);
    	theForm.fill(new RequisitionPOJO());
    	return ok(views.html.cases.create_case.render(theForm, tests, null));
    }

    @Transactional
    public static Result saveCase() {
    	List<TestEntityObject> tests = TestEntityObject.getAllTests();
    	Form<RequisitionPOJO> theForm = form(RequisitionPOJO.class).bindFromRequest();
    	
    	//make sure everything is peachy with the form.
    	if(theForm.hasErrors()){
    		List<String> err = new LinkedList<String>();
    		err.add("Error#1");
    		err.add("err#2");
    		return badRequest(views.html.cases.create_case.render(theForm, tests, err));
    	}else{
	    	
	    	RequisitionPOJO req = theForm.get();
	    	//check if caseNumber is unique
	    	
	    	//check if receivedByEmployee is valid #
	    	
	    	//create case entity object, and fill in fields
	    	
	    	//for each testNumber[] > 0
	    		//create caseTest object
	    		//link caseTest objects to TestEntity objects
	    		//link caseTest object to case object
	    	
	    	
	    	
	    	//Lets see how array submission works, shall we?
	    	String res = "Results are: ";
	    	for(int i = 0; i < req.testNumber.length; i++){
	    		res += "!! " + req.testNumber[i];
	    	}
	    	return ok(res + "\n\n" + req.dateCollected +
	    			"\nEmployee#: " + req.receivedByEmployee);
    	}
    }
}
