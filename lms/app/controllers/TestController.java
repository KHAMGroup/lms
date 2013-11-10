package controllers;

import static play.data.Form.form;

import models.TestEntityObject;

import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

@Security.Authenticated(Avocado.class)
public class TestController extends Controller {

	@Transactional
	public static Result tests() {
    	if(Avocado.hasRole("admin")){
	        return ok(
		        	views.html.test.tests.render(TestEntityObject.getAllTests())
		    );
    	}
		else{
			return redirect(routes.MainController.returnToDashboard());
		}
	}
	
	@Transactional
	public static Result newTest() {
    	if(Avocado.hasRole("admin")){	
    		Form<TestEntityObject> newTestForm = form(TestEntityObject.class);
	        return ok(
		        	views.html.test.test.render(newTestForm)
		    );
    	}
		else{
			return redirect(routes.MainController.returnToDashboard());
		}
	}
	
	@Transactional
	public static Result save() {
		Form<TestEntityObject> toSaveForm = form(TestEntityObject.class).bindFromRequest();
		if(toSaveForm.hasErrors()){
			return badRequest(views.html.test.test.render(toSaveForm));
		}
		toSaveForm.get().save();
        return redirect(routes.TestController.tests());
	}
	
	@Transactional
	public static Result edit(int id) {
    	if(Avocado.hasRole("admin")){	
    		Form<TestEntityObject> testForm = form(TestEntityObject.class)
    				.fill(TestEntityObject.findByTestNumber(id));
	        return ok(
		        	views.html.test.test.render(testForm)
		    );
    	}
		else{
			return redirect(routes.MainController.returnToDashboard());
		}
	}
	
	@Transactional
	public static Result update(int id) {
    	return null;
	}
}
