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
public class ClientController extends Controller {

    public static Result search(String searchString) {
		if(Avocado.hasRole("manage_clients")){
			String trimmed = searchString.trim();
			List<Client> clientsFound = new LinkedList<Client>();
			if(SearchTools.isFirstThenLast(trimmed)){
				String[] firstAndLast = SearchTools.getFirstAndLast(trimmed);
				String first = firstAndLast[0];
				String last = firstAndLast[1];
				clientsFound.addAll(Client.findByFirstAndLastName(first, last));
			}
			else if(SearchTools.isFirstOrLast(trimmed)){
				clientsFound.addAll(Client.findByFirstOrLastName(trimmed));
			}
			else if(SearchTools.isLastThenFirst(trimmed)){
				String[] lastAndFirst = SearchTools.getLastAndFirst(trimmed);
				String first = lastAndFirst[1];
				String last = lastAndFirst[0];
				clientsFound.addAll(Client.findByFirstAndLastName(first, last));
			}
	//			return ok(views.html.dashboard.render(clientsFound));
			
			return ok();
		}
		else{
			return forbidden();
		}
    }
    
    
    @Transactional
    public static Result createClient() {
		if (Avocado.hasRole("manage clients")) {
			return ok(views.html.client.create_client.render(new Client(), form(Client.class)));
		} else {
			return forbidden();
		}
    }
    
    @Transactional
    public static Result saveClient() {
		Form<Client> newClientForm = form(Client.class).bindFromRequest();
		if(newClientForm.hasErrors()){
			return badRequest(views.html.client.create_client.render(newClientForm.get(), newClientForm));
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
