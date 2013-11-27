package controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import controllers.MainController.SearchQuery;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
import play.db.jpa.Transactional;
import models.*;
import models.helpers.ReportHelper;

@Security.Authenticated(Avocado.class)
public class ReportController extends Controller {
	
	@Transactional
	public static Result createReport(String caseNumber) {
		CaseEntityObject theCase = CaseEntityObject.findByCaseNumber(caseNumber);
		if(theCase == null){
			return redirect(routes.MainController.searchResults("Case", caseNumber));
		}
		
		ReportPOJO report = new ReportPOJO();
		Form<ReportPOJO> reportForm = form(ReportPOJO.class).fill(report);
		return ok(views.html.report.edit_report.render(theCase, reportForm));
	}
}
