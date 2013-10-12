package controllers;

import controllers.Application.Login;
import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.*;
import play.db.jpa.Transactional;
import models.*;

@Security.Authenticated(Avocado.class)
public class ClientController extends Controller {

    public static Result search() {
		if (Avocado.hasRole("manage_clients")) {
			return TODO;
		} else {
			return forbidden();
		}
    }
    
    
    @Transactional
    public static Result createClient() {
		if (Avocado.hasRole("manage_clients")) {
			return ok(views.html.create_client.render(new Client(), form(Client.class)));
		} else {
			return forbidden();
		}
    }
    
    @Transactional
    public static Result saveClient() {
		Form<Client> newClientForm = form(Client.class).bindFromRequest();
		if(newClientForm.hasErrors()){
			return badRequest(views.html.create_client.render(newClientForm.get(), newClientForm));
		}else{
			newClientForm.get().save();
	    	return redirect(routes.MainController.returnToDashboard());
		}
    }
    

    public static Result enterRequisition() {
	return TODO;
    } 

    public static Result createCase() {
	return TODO;
    }
}
