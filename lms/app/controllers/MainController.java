package controllers;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
import play.db.jpa.Transactional;
import models.*;

@Security.Authenticated(Avocado.class)
public class MainController extends Controller {
    
    public static Result returnToDashboard() {
    	return TODO;
    }

    public static Result createClient() {
	return TODO;
    }

    public static Result search(Object data, String clientOrCase) {
	return TODO;
    }

    public static Result printWorksheet() {
	return TODO;
    }

    public static Result enterResults() {
	return TODO;
    }
}
