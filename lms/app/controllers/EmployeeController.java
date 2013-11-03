package controllers;

import static play.data.Form.*;
import models.Employee;
import models.EmployeePOJO;
import models.helpers.EmployeeHelper;
import play.*;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

public class EmployeeController extends Controller {
  

//    @Transactional
//    public static Result employee(Integer id){
//        Form<EmployeePOJO> employeeForm = form(EmployeePOJO.class).fill(
//        			EmployeeHelper.getEmployeePOJO(id)
//        );
//        return ok(
//            views.html.employee.employee.render("V", employeeForm)
//        );
//    }
	@Transactional
	public static Result editEmployee(Integer id){
	    Form<EmployeePOJO> employeeForm = form(EmployeePOJO.class).fill(
	      			EmployeeHelper.getEmployeePOJO(id)
	    );
	    return ok(
	        views.html.employee.employee.render(employeeForm)
	    );
	}
	
    @Transactional(readOnly=true)
    public static Result employees(){
        return ok(
        	views.html.employee.employees.render(EmployeeHelper.getAll())
        );
    }
    
    @Transactional
    public static Result newEmployee(){
        Form<EmployeePOJO> employeeForm = form(EmployeePOJO.class);
        return ok(
            views.html.employee.createEmployee.render(employeeForm)
        );
    }
    
    @Transactional
    public static Result save() {
        Form<EmployeePOJO> employeeForm = form(EmployeePOJO.class).bindFromRequest();
        if(employeeForm.hasErrors()) {
            return badRequest(views.html.employee.createEmployee.render(employeeForm));
        }
        if(Employee.findByUserName(employeeForm.get().getUserName()) != null){
        	flash("userexists", "User Name already exists");
        	return badRequest(views.html.employee.createEmployee.render(employeeForm));
        }
        EmployeeHelper.save(employeeForm.get());
        return redirect(routes.EmployeeController.employees());
    }
    
    @Transactional
    public static Result update(Integer employeeNumber){
        Form<EmployeePOJO> employeeForm = form(EmployeePOJO.class).bindFromRequest();
        if(employeeForm.hasErrors()) {
            return badRequest(views.html.employee.employee.render(employeeForm));
        }
        Employee existing = Employee.findByUserName(employeeForm.get().getUserName());
        
        if(existing != null && existing.getEmployeeNumber() != employeeNumber){
        	flash("userexists", "User Name already exists");
        	return badRequest(views.html.employee.employee.render(employeeForm));
        }
        EmployeeHelper.update(employeeNumber, employeeForm.get());
        return redirect(routes.EmployeeController.employees());
    }
//    
//    public static Result deleteEmployee(Integer id){
//    	return TODO;
//    }
}
