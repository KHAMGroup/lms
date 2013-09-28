package controllers;

import play.*;
import play.mvc.*;
import static play.data.Form.*;
import play.data.Form;
import play.db.jpa.Transactional;
import models.*;

public class Application extends Controller {

    @Security.Authenticated(DDLAuthenticator.class)
    public static Result index() {
        return ok(views.html.index.render("Your new application is ready."));
    }


    public static Result login() {
	return ok(views.html.login.render(form(Login.class)));
    }

    public static Result logout() {
	session().clear();
	flash("success", "You've been logged out");
	return redirect(routes.Application.login());
    }

    @Transactional
    public static Result authenticate() {
	Form<Login> loginForm = form(Login.class).bindFromRequest();
	if(loginForm.hasErrors()) {
		System.out.println("badrequest");
		return badRequest(views.html.login.render(loginForm));
	} else {
		System.out.println("redirecting");
		session().clear();
		session("username", loginForm.get().getUserName());

		return redirect(
			routes.Application.index()
		);
	}
    }

  
    public static class Login {

	private String username;
	private String password;

	public String getUserName(){return username;}
	public String getPassword(){return password;}

	public void setUserName(String userName){
		this.username = userName;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String validate() {
		if (Employee.authenticate(username, password) == null) {
		    return "Invalid user or password";
		}
		    return null;
	}
    }  
}
