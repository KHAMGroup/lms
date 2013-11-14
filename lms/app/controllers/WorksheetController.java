package controllers;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
import play.db.jpa.Transactional;
import models.*;

@Security.Authenticated(Avocado.class)
public class WorksheetController extends Controller {

    public static Result printWorksheet() {
	if (Avocado.hasRole("print worksheet")) {
//		return ok();
		return TODO;
	} else {
		return forbidden();
	}
    }

    public static Result printWorksheet(int testNumber) {
	if (Avocado.hasRole("print worksheet")) {
//		return ok();
		return TODO;
	} else {
		return forbidden();
	}
    }

    public static Result enterResults() {
	if (Avocado.hasRole("enter results")) {
//		return ok();
		return TODO;
	} else {
		return forbidden();
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

    public static Result getTestsNeedingResults() {
    	
    	return TODO;
    }

    public static Result getCasesForWorksheet(int testNumber) {
	return TODO;
    }

    private static void createPDF(){

    }


}
