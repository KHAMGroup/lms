package controllers;

import static play.data.Form.*;
import models.Employee;

import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;

import views.html.*;

public class EmployeeApp extends Controller {

    
    @Transactional
    public static Result employee(Integer id){
        Form<Employee> employeeForm = form(Employee.class).fill(
        			Employee.findById(id)
        );
        return ok(
            views.html.employee.render(employeeForm.get(),employeeForm)
        );
    }
    
    @Transactional(readOnly=true)
    public static Result employees(){
        return ok(
        	views.html.employees.render(Employee.all())
        );
    }
    
    @Transactional
    public static Result create(){
        Form<Employee> employeeForm = form(Employee.class);
        return ok(
            views.html.createEmployee.render(new Employee(),employeeForm)
        );
    }
    
    @Transactional
    public static Result save() {
        Form<Employee> employeeForm = form(Employee.class).bindFromRequest();
        if(employeeForm.hasErrors()) {
            return badRequest(views.html.employee.render(employeeForm.get(),employeeForm));
        }
        employeeForm.get().save();
        return GO_HOME;
    }
    
    @Transactional
    public static Result update(Integer employeeNumber){
        Form<Employee> employeeForm = form(Employee.class).bindFromRequest();
        if(employeeForm.hasErrors()) {
            return badRequest(views.html.employee.render(employeeForm.get(),employeeForm));
        }
        employeeForm.get().update(employeeNumber);
        return GO_HOME;
    }
    
    @Transactional
    public static Result delete(Integer id){
    	Employee.findById(id).delete();
    	return GO_HOME;
    }
    
    private static Result GO_HOME = redirect(routes.EmployeeApp.employees());
}
