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
	if(Avocado.hasRole("manage deposits")){
		Deposit found = Deposit.findByDepositNumber(depositId);
	    	Form<Deposit> depositForm = form(Deposit.class).fill(found);
		return ok();
	}
	else{
		return redirect(routes.MainController.returnToDashboard());
	}
    }

    @Transactional
    public static Result createDeposit(int clientId) {
	Client client = Client.findByClientNumber(clientId);
    	if(client == null){
    		return redirect(routes.MainController.returnToDashboard());
    	}else{
		Form<Deposit> newDepositForm = form(Deposit.class);
		Deposit newDeposit = new Deposit();
		newDeposit.setClient(client);
		newDepositForm = newDepositForm.fill(newDeposit);
        	return ok();
    	}
    }
    
    @Transactional
    public static Result saveDeposit(int clientId) {
		Form<Deposit> newDepositForm = form(Deposit.class).bindFromRequest();
		if(newDepositForm.hasErrors()){
			return redirect(routes.MainController.returnToDashboard());
		}else{
			Client theClient = Client.findByClientNumber(clientId);
			newDepositForm.get().setClient(theClient);
			newDepositForm.get().save();
	    	return ok();
		}
    }

    @Transactional
    public static Result getDepositRefund(int depositId) {
		if (Avocado.hasRole("manage deposits")) {
	    	Deposit theDeposit = Deposit.findByDepositNumber(depositId);
	    	DepositRefund refund = new DepositRefund();
	    	refund.setDeposit(theDeposit);
	    	Form<DepositRefund> depositRefundForm = form(DepositRefund.class).fill(refund);
	    	return ok();
		}
		else{
			return redirect(routes.MainController.returnToDashboard());
		}
    }

    @Transactional
    public static Result saveDepositRefund(int depositId) {
		Form<DepositRefund> depositRefundForm = form(DepositRefund.class).bindFromRequest();
		if(depositRefundForm.hasErrors()){
			return redirect(routes.MainController.returnToDashboard());
		}else{
			Deposit theDeposit = Deposit.findByDepositNumber(depositId);
			List<DepositRefund> refunds = theDeposit.getRefunds();
			if(refunds==null){
				refunds = new LinkedList<DepositRefund>();
			}
			refunds.add(depositRefundForm.get());
			theDeposit.setRefunds(refunds);
			theDeposit.update(depositId);
		
	    	return ok();
		}
    }
}
