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
		return TODO;
	}
	
	@Transactional
	public Result create(){
		return TODO;
	}

	@Transactional
	public Result save(){
		return TODO;
	}
	
	@Transactional
	public Result update(Integer depositNumber){
		return TODO;
	}
	
	@Transactional
	public Result delete(Integer depositNumber){
		return TODO;
	}
}
