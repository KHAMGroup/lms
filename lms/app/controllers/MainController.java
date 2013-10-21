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
    		return ok(views.html.dashboard.render(user, user.getUserRolesAsStrings(), null, null, form(SearchQuery.class)));
    	}else{
    		return redirect(routes.Application.login());
    	}
    }

//    public static Result showDashboard() {
//    	Employee user = Avocado.getCurrentUser();
//    	if(user!=null){
//		Form<SearchResults> searchResultsForm = form(SearchResults.class).bindFromRequest();
//		String clientOrCase = searchResultsForm.get().clientOrCase;
//		if(clientOrCase.equals("Client")){
//	    		return ok(views.html.dashboard.render(user, user.getUserRolesAsStrings(), searchResultsForm.get().clientsFound, null, form(SearchQuery.class)));
//		}else if(clientOrCase.equals("Case")){
//			return ok(views.html.dashboard.render(user, user.getUserRolesAsStrings(), null, searchResultsForm.get().casesFound, form(SearchQuery.class)));
//		}else{
//			return ok(views.html.dashboard.render(user, user.getUserRolesAsStrings(), null, null, form(SearchQuery.class)));
//		}
//
//    	}else{
//    		return redirect(routes.Application.login());
//    	}
//    }
    
	public static Result showDashboardWithClients(List<Client> clientsFound) {
		Employee user = Avocado.getCurrentUser();
		if(user!=null){
			return ok(views.html.dashboard.render(user, user.getUserRolesAsStrings(), clientsFound, null, form(SearchQuery.class)));
		}
		else{
			return redirect(routes.Application.login());
		}
	}
	
	public static Result showDashboardWithCases(List<CaseEntityObject> casesFound) {
		Employee user = Avocado.getCurrentUser();
		if(user!=null){
			return ok(views.html.dashboard.render(user, user.getUserRolesAsStrings(), null, casesFound, form(SearchQuery.class)));
		}
		else{
			return redirect(routes.Application.login());
		}
	}

    public static Result createClient() {
    	return ClientController.createClient();
    }
    
	@Transactional
    public static Result searchResults(String clientOrCase, String data) {
    	if(clientOrCase.equals("client")){
    		return ClientController.search(data);
    	}else if(clientOrCase.equals("case")){
    		return CaseController.search(data);
    	}else{
    		return returnToDashboard();
    	}
    }

    public static Result search() {
		Form<SearchQuery> searchForm = form(SearchQuery.class).bindFromRequest();
		String clientOrCase = searchForm.get().clientOrCase.toLowerCase();
		String trimmed = searchForm.get().data.trim();
		String searchQueryData = " ";
		System.out.println(trimmed);
		if(SearchTools.isFirstThenLast(trimmed)){
			String[] firstAndLast = SearchTools.getFirstAndLast(trimmed);
			String first = firstAndLast[0];
			String last = firstAndLast[1];
			searchQueryData = first+"+"+last;
		}
		else if(SearchTools.isFirstOrLast(trimmed)){
			searchQueryData = trimmed;
		}
		else if(SearchTools.isLastThenFirst(trimmed)){
			String[] lastAndFirst = SearchTools.getLastAndFirst(trimmed);
			String first = lastAndFirst[1];
			String last = lastAndFirst[0];
			searchQueryData = first+"+"+last;
		}
		return redirect(routes.MainController.searchResults(clientOrCase,searchQueryData));
    }    


    public static Result printWorksheet() {
	return TODO;
    }

    public static Result enterResults() {
	return TODO;
    }

    public static class SearchQuery {
    	public String clientOrCase;
	public String data;

	public static List<String> options(){
		List<String> options = new ArrayList<String>();
		options.add("client");options.add("case");return options;
	}
    }  

//    public static class SearchResults {
//	public String clientOrCase;
//	public List<Client> clientsFound;
//	public List<CaseEntityObject> casesFound;
//    }
}
