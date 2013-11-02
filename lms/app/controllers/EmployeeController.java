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
  

    @Transactional
    public static Result employee(Integer id){
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
//    
//    @Transactional
//    public static Result newEmployee(){
//        Form<Employee> employeeForm = form(Employee.class);
//        return ok(
//            views.html.employee.createEmployee.render(employeeForm)
//        );
//    }
//    
//    @Transactional
//    public static Result save() {
//        Form<Employee> employeeForm = form(Employee.class).bindFromRequest();
//        if(employeeForm.hasErrors()) {
//            return badRequest(views.html.employee.employee.render(employeeForm));
//        }
//        employeeForm.get().save();
//        return redirect(routes.EmployeeController.employees());
//    }
//    
//    @Transactional
//    public static Result update(Integer employeeNumber){
//        Form<Employee> employeeForm = form(Employee.class).bindFromRequest();
//        if(employeeForm.hasErrors()) {
//            return badRequest(views.html.employee.employee.render(employeeForm));
//        }
//        employeeForm.get().update(employeeNumber);
//        return redirect(routes.EmployeeController.employees());
//    }
//    
//    public static Result deleteEmployee(Integer id){
//    	return TODO;
//    }
}
