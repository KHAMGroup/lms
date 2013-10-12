package controllers;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
import play.db.jpa.Transactional;
import models.*;

@Security.Authenticated(Avocado.class)
public class CaseController extends Controller {

    public static Result search(String data) {
	if (Avocado.hasRole("manage_cases")) {
//		return ok();
		return TODO;
	} else {
		return forbidden();
	}
    }

    public static Result createCase() {
	return TODO;
    }
}
