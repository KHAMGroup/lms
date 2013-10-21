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
		String trimmed = searchString.trim();
		List<CaseEntityObject> casesFound = new LinkedList<CaseEntityObject>();
		if(SearchTools.isFirstThenLast(trimmed)){
			String[] firstAndLast = SearchTools.getFirstAndLast(trimmed);
			String first = firstAndLast[0];
			String last = firstAndLast[1];
			casesFound.addAll(CaseEntityObject.findBySubjectFirstAndLastName(first, last));
		}
		else if(SearchTools.isFirstOrLast(trimmed)){
			casesFound.addAll(CaseEntityObject.findBySubjectFirstOrLastName(trimmed));
		}
		else if(SearchTools.isLastThenFirst(trimmed)){
			String[] lastAndFirst = SearchTools.getLastAndFirst(trimmed);
			String first = lastAndFirst[1];
			String last = lastAndFirst[0];
			casesFound.addAll(CaseEntityObject.findBySubjectFirstAndLastName(first, last));
		}
//			return ok(views.html.dashboard.render(casesFound));
		return MainController.showDashboardWithCases(casesFound);
    }

    public static Result createCase() {
    	return ok(views.html.cases.create_case.render(form(RequisitionPOJO.class), null));
    }

    public static Result saveCase() {
    	
    	Form<RequisitionPOJO> theForm = form(RequisitionPOJO.class).bindFromRequest();
    	
    	//make sure everything is peachy with the form.
    	if(theForm.hasErrors()){
    		return badRequest(views.html.cases.create_case.render(theForm, null));
    	}else{
	    	//everything's peachy. lets create a reqpojo
	    	RequisitionPOJO req = theForm.get();
	    	//Lets see how array submission works, shall we?
	    	String res = "Results are: ";
	    	for(int i = 0; i < req.testNumber.length; i++){
	    		res += "!! " + req.testNumber[i];
	    	}
	    	return ok(res + "\n\n" + req.dateCollected);
    	}
    }
}
