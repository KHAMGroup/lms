package models.helpers;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import models.Employee;
import models.EmployeePOJO;
import models.UserRole;

public class EmployeeHelper {
	private static final String DEFAULT_PASSWORD = "ddl";
	private static final String ADMIN_ROLE = "admin";
	private static final String CLIENT_ROLE = "manage clients";
	private static final String CASES_ROLE = "manage cases";
	private static final String RESULTS_ROLE = "manage case results";
	
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
			toReturn.setAdmin(roles.contains(ADMIN_ROLE));
			toReturn.setManageClients(roles.contains(CLIENT_ROLE));
			toReturn.setManageCases(roles.contains(CASES_ROLE));
			toReturn.setManageCaseResults(roles.contains(RESULTS_ROLE));
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

	
	
	public static void save(EmployeePOJO employeePOJO) {
		Employee toSave = new Employee();
		toSave.setFirst(employeePOJO.getFirst());
		toSave.setLast(employeePOJO.getLast());
		toSave.setUserName(employeePOJO.getUserName());
		toSave.setPassword(DEFAULT_PASSWORD);
		List<UserRole> userRoles = new LinkedList<UserRole>();
		if(employeePOJO.isAdmin()){
			UserRole admin = new UserRole();
			admin.setRoleName(ADMIN_ROLE);
			userRoles.add(admin);
		}
		if(employeePOJO.isManageClients()){
			UserRole clients = new UserRole();
			clients.setRoleName(CLIENT_ROLE);
			userRoles.add(clients);
		}
		if(employeePOJO.isManageCases()){
			UserRole cases = new UserRole();
			cases.setRoleName(CASES_ROLE);
			userRoles.add(cases);
		}
		if(employeePOJO.isManageCaseResults()){
			UserRole results = new UserRole();
			results.setRoleName(RESULTS_ROLE);
			userRoles.add(results);
		}
		toSave.setUserRoles(userRoles);
		toSave.save();


	}

}
