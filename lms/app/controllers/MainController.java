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
