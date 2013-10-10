package controllers;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
import play.db.jpa.Transactional;
import models.*;

@Security.Authenticated(Avocado.class)
public class ClientController extends Controller {

    public static Result createClient() {
	if (Avocado.hasRole("manage_clients")) {
//		return ok();
		return TODO;
	} else {
		return forbidden();
	}
    }

    public static Result search() {
	if (Avocado.hasRole("manage_clients")) {
//		return ok();
		return TODO;
	} else {
		return forbidden();
	}
    }

    public static Result saveClient() {
	if (Avocado.hasRole("manage_clients")) {
//		return ok();
		return TODO;
	} else {
		return forbidden();
	}
    }

    public static Result returnToDashboard() {
	return TODO;
    }

    public static Result enterRequisition() {
	return TODO;
    } 

    public static Result createCase() {
	return TODO;
    }
}
