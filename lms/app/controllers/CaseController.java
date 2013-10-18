package controllers;

import java.util.LinkedList;
import java.util.List;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
import play.db.jpa.Transactional;
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
	return TODO;
    }

    public static Result saveCase() {
	return TODO;
    }
}
