package models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints;
import play.db.jpa.*;

/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_number", nullable=false)
	private int employeeNumber;
	
	@Column(nullable=false, length=20)
	@Constraints.Required
	private String first;
	
	@Column(nullable=false, length=20)
	@Constraints.Required
	private String last;

	@Column(length=20)
	private String password;

	@Column(name="user_role")
	private int userRole;
	
	@Column(nullable=false, length=20)
	@Constraints.Required
	private String username;

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

	public int getUserRole() {
		return this.userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
    public static Employee findById(int id) {
        return JPA.em().find(Employee.class, id);
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
    
    public static List<Employee> all(){
    	return JPA.em().createQuery("from Employee").getResultList();
    }
}