package controllers;

import static play.data.Form.*;
import models.Deposit;
import models.Client;

import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

public class ClientApp extends Controller {

	@Transactional
	public Result client(Integer id){
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
	public Result update(Integer clientNumber){
		return TODO;
	}
	
	@Transactional
	public Result delete(Integer clientNumber){
		return TODO;
	}
}
