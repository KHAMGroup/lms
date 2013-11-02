package models.helpers;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import models.Employee;
import models.EmployeePOJO;

public class EmployeeHelper {

	public static EmployeePOJO getEmployeePOJO(int findById) {
		return employeeToPOJO(Employee.findById(findById));
	}

	private static EmployeePOJO employeeToPOJO(Employee employee){
		EmployeePOJO toReturn = new EmployeePOJO();
		if(employee!=null){
			toReturn.setEmployeeNumber(employee.getEmployeeNumber());
			toReturn.setFirst(employee.getFirst());
			toReturn.setLast(employee.getLast());
			toReturn.setUserName(employee.getUserName());
			Set<String> roles = employee.getUserRolesAsStrings();
			if(roles.contains("admin")){
				toReturn.setAdmin(true);
			}else{
				toReturn.setAdmin(false);
			}
			if(roles.contains("manage clients")){
				toReturn.setManageClients(true);
			}else{
				toReturn.setManageClients(false);
			}
			if(roles.contains("manage cases")){
				toReturn.setManageCases(true);
			}else{
				toReturn.setManageCases(false);
			}
			if(roles.contains("manage results")){
				toReturn.setManageCaseResults(true);
			}else{
				toReturn.setManageCaseResults(false);
			}
		}
		return toReturn;
	}
	
	public static List<EmployeePOJO> getAll() {
		List<Employee> allEmployees = Employee.all();
		List<EmployeePOJO> employeesAsPOJOs = new LinkedList<EmployeePOJO>();
		for(Employee employee : allEmployees){
			employeesAsPOJOs.add(employeeToPOJO(employee));
		}
		return employeesAsPOJOs;
	}

}
