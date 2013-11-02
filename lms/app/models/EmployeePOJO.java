package models;



public class EmployeePOJO {

	private int employeeNumber;
	private String first;
	private String last;
	private String password;
	private String username;
	
	private boolean admin;
	private boolean manageClients;
	private boolean manageCases;
	private boolean manageCaseResults;
	
	public EmployeePOJO(){}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isManageClients() {
		return manageClients;
	}

	public void setManageClients(boolean manageClients) {
		this.manageClients = manageClients;
	}

	public boolean isManageCases() {
		return manageCases;
	}

	public void setManageCases(boolean manageCases) {
		this.manageCases = manageCases;
	}

	public boolean isManageCaseResults() {
		return manageCaseResults;
	}

	public void setManageCaseResults(boolean manageCaseResults) {
		this.manageCaseResults = manageCaseResults;
	}
	
}
