package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;

public class Avocado extends Security.Authenticator {
	
	@Override
	public String getUsername(Context ctx) {
		return ctx.session().get("username");
	}

	@Override
	public Result onUnauthorized(Context ctx) {
		return redirect(routes.Application.login());
	}

	public static boolean hasRole(String userRole) {
//		Employee found = Employee.findByUserName(Context.current().request().username());
//		boolean hasRole = false;
//		if(found!=null && found.hasUserRole(userRole)){
//			hasRole = true;
//		}
//		return hasRole;
		return Employee.hasUserRole(Context.current().request().username(), userRole);
	}
}
