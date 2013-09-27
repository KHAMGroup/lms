package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
/*
    public static Result login() {
	return ok(login.render(form(Login.class)));
    }

    public static Result logout() {
	session().clear();
	flash("success", "You've been logged out");
	return redirect(routes.Application.login());
    }

    public static Result authenticate() {
	Form<Login> loginForm = form(Login.class).bindFromRequest();
	if(loginForm.hasErrors()) {
		return badRequest(login.render(loginForm));
	} else {
		session().clear();
		session("username", loginForm.get().getUserName());
		return redirect(
			routes.Application.index()
		);
	}
    }

  
    private static class Login {

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
		if (Employee.authenticate(email, password) == null) {
		    return "Invalid user or password";
		}
		    return null;
	}
    }  */
}
