package controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
import play.db.jpa.Transactional;
import models.*;
import models.helpers.WorksheetHelper;

@Security.Authenticated(Avocado.class)
public class WorksheetController extends Controller {

    public static Result printWorksheet() {
		if (Avocado.hasRole("manage cases")) {
			return ok(views.html.worksheet.selectTest.render(WorksheetHelper.getTestsNeedingResults()));
		} else {
			return redirect(routes.MainController.returnToDashboard());
		}
    }

    @Transactional
    public static Result getCasesForWorksheet(int testNumber) {
		if (Avocado.hasRole("manage cases")) {
			TestEntityObject theTest = TestEntityObject.findByTestNumber(testNumber);
			if(theTest == null){
				return redirect(routes.MainController.printWorksheet());
			}
			List<CaseTest> caseTests = CaseTest.caseTestsNeedingResults(testNumber);
			Date today = new Date(Calendar.getInstance().getTimeInMillis());
			return ok(views.html.worksheet.worksheet.render(theTest, caseTests, today));
		} else {
			return redirect(routes.MainController.returnToDashboard());
		}
    }

    public static Result enterResults() {
		if (Avocado.hasRole("manage results")) {
			return ok(views.html.worksheet.selectTest.render(WorksheetHelper.getTestsNeedingResults()));
		} else {
			return redirect(routes.MainController.returnToDashboard());
		}
    }

    public static Result enterResults(int testNumber) {
		if (Avocado.hasRole("enter results")) {
	//		return ok();
			return TODO;
		} else {
			return forbidden();
		}
    }


    public static Result enterResultsTest() {
		if (Avocado.hasRole("enter results")) {
	//		return ok();
			return TODO;
		} else {
			return forbidden();
		}
    }

    public static Result saveData() {
	return TODO;
    }


    private static void createPDF(){

    }


}
