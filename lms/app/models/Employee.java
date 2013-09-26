package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import play.db.jpa.*;

/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_number", unique=true, nullable=false)
	private int employeeNumber;

	@Column(nullable=false, length=20)
	private String first;

	@Column(nullable=false, length=20)
	private String last;

	@Column(length=20)
	private String password;

	@Column(nullable=false, length=20)
	private String username;

	//bi-directional many-to-one association to CaseEntityObject
	@OneToMany(mappedBy="receivedByEmployee")
	private List<CaseEntityObject> casesReceived;

	//bi-directional many-to-one association to CaseTest
	@OneToMany(mappedBy="employeeEntered")
	private List<CaseTest> caseTestsEntered;

	//bi-directional many-to-one association to CaseTest
	@OneToMany(mappedBy="employeePerformed")
	private List<CaseTest> caseTestsPerformed;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="employee")
	private List<UserRole> userRoles;

	public Employee() {
	}

	public int getEmployeeNumber() {
		return this.employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFirst() {
		return this.first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return this.last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public List<CaseEntityObject> getCasesReceived() {
		return this.casesReceived;
	}

	public void setCasesReceived(List<CaseEntityObject> casesReceived) {
		this.casesReceived = casesReceived;
	}

	public List<CaseTest> getCaseTestsEntered() {
		return this.caseTestsEntered;
	}

	public void setCaseTestsEntered(List<CaseTest> caseTestsEntered) {
		this.caseTestsEntered = caseTestsEntered;
	}

	public List<CaseTest> getCaseTestsPerformed() {
		return this.caseTestsPerformed;
	}

	public void setCaseTestsPerformed(List<CaseTest> caseTestsPerformed) {
		this.caseTestsPerformed = caseTestsPerformed;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}
	
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

    public static Employee findById(int id) {
        return JPA.em().find(Employee.class, id);
    }
    
    public static List<Employee> findByUserName(String user) {
	String query = "from Employee where username = '"+user+"' ";
	return JPA.em().createQuery(query).getResultList(); 
    }

    public void update(int employeeNumber) {
    	setEmployeeNumber(employeeNumber);
    	JPA.em().merge(this);
    }
    
    public void save(){
        JPA.em().persist(this);
    }
    
    public void delete() {
        JPA.em().remove(this);
    }
    
}
