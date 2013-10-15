package controllers;

import java.util.ArrayList;
import java.util.List;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
import play.db.jpa.Transactional;
import models.*;

@Security.Authenticated(Avocado.class)
public class MainController extends Controller {
    
	@Transactional
    public static Result returnToDashboard() {
    	Employee user = Avocado.getCurrentUser();
    	if(user!=null){
    		return ok(views.html.dashboard.render(user, user.getUserRolesAsStrings(), null, null));
    	}else{
    		return forbidden();
    	}
    }

    public static Result createClient() {
    	return ClientController.createClient();
    }

    public static Result search(String data, String clientOrCase) {
    	if(clientOrCase.equals("Client")){
    		return ClientController.search(data);
    	}else if(clientOrCase.equals("Case")){
    		return CaseController.search(data);
    	}else{
    		return returnToDashboard();
    	}
    }

    
    public static Result printWorksheet() {
	return TODO;
    }

    public static Result enterResults() {
	return TODO;
    }
}
