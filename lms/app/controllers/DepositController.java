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
public class DepositController extends Controller {

    @Transactional
    public static Result viewDeposit(int depositId) {
	if(Avocado.hasRole("manage clients")){
		Deposit found = Deposit.findByDepositNumber(depositId);
	    	Form<Deposit> depositForm = form(Deposit.class).fill(theDeposit);
		return TODO;
	}
	else{
		return redirect(routes.MainController.returnToDashboard());
	}
    }

    @Transactional
    public static Result createDeposit(int clientId) {
	return TODO;
    }
    
    @Transactional
    public static Result saveDeposit(int clientId) {
	return TODO;
    }

    @Transactional
    public static Result getDepositForRefund(int depositId) {
	return TODO;
    }

    @Transactional
    public static Result saveRefundedDeposit(int depositId) {
	return TODO;
    }
}
