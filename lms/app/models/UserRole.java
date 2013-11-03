package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USER_ROLES database table.
 * 
 */
@Entity
@Table(name="USER_ROLES")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="role_name", nullable=false, length=64)
	private String roleName;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_PK", unique=true, nullable=false)
	private int role_PK;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_number", nullable=false)
	private Employee employee;

	public UserRole() {
	}

	public UserRole(Employee employee, String roleName){
		setEmployee(employee);
		setRoleName(roleName);
	}
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
