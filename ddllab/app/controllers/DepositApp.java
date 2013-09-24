package controllers;

import static play.data.Form.*;
import models.Deposit;
import models.Client;

import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

public class DepositApp extends Controller {

	@Transactional
	public Result deposit(Integer id){
        Form<Deposit> depositForm = form(Deposit.class).fill(
    			Deposit.findById(id)
        );
		return TODO;
	}
	
	@Transactional
	public Result create(){
		return TODO;
	}

	@Transactional
	public Result save(){
        Form<Deposit> depositForm = form(Deposit.class).bindFromRequest();
//        if(depositForm.hasErrors()) {
//            return badRequest(views.html.deposit.render(depositForm.get(),depositForm));
//        }
        depositForm.get().save();
		return TODO;
	}
	
	@Transactional
	public Result update(Integer depositNumber){
        Form<Deposit> depositForm = form(Deposit.class).bindFromRequest();
//      if(depositForm.hasErrors()) {
//          return badRequest(views.html.deposit.render(depositForm.get(),depositForm));
//      }
        depositForm.get().update(depositNumber);
		return TODO;
	}
	
	@Transactional
	public Result delete(Integer depositNumber){
		Deposit.findById(depositNumber).delete();
		return TODO;
	}
	
	
}
