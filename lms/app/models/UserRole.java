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

	@Column(name="privilege_name", nullable=false, length=64)
	private String privilegeName;

	@Id
	@Column(name="surrogate_key")
	private int surrogateKey;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employee_number", nullable=false)
	private Employee employee;

	public UserRole() {
	}

	public String getPrivilegeName() {
		return this.privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
